package com.hiberus.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hiberus.prueba.dao.IHeroDao;
import com.hiberus.prueba.exception.HeroNotFoundException;
import com.hiberus.prueba.model.Hero;
import com.hiberus.prueba.model.HeroRequest;
import com.hiberus.prueba.time.ExecutionTime;

@Service
public class HeroService implements IHeroService {

	private IHeroDao heroDao;

	@Autowired
	public HeroService(final IHeroDao heroDao) {
		super();
		this.heroDao = heroDao;
	}
	
	@Override
	@ExecutionTime
	@Cacheable("heroes")
	public List<Hero> getAllHero() {
		return heroDao.findAll();
	}

	@Override
	@ExecutionTime
	@Cacheable("heroes")
	public Hero getHeroById(final Long id)  {
		Optional<Hero> hero = heroDao.findById(id);
		if(hero.isEmpty()) {
			throw new HeroNotFoundException("Not found the Hero with id: " + id); 
		}
		return hero.get();
	}

	@Override
	@ExecutionTime
	public List<Hero> getHeroesByName(String name) {
		return heroDao.findByNameLike("%" + name + "%");
				
	}

	@Override
	@ExecutionTime
	@CacheEvict(cacheNames="heroes", allEntries=true)
	public void deleteHero(final Long id) {
		Optional<Hero> hero = heroDao.findById(id);
		if(hero.isEmpty()) {
			throw new HeroNotFoundException("Not found the Hero with id: " + id); 
		}
		heroDao.delete(hero.get());
	}

	@Override
	@ExecutionTime
	@CacheEvict(cacheNames="heroes", allEntries=true)
	public Long createHero(HeroRequest heroRequest) {
		return heroDao.save(generateHeroObject(heroRequest)).getId();
		
	}

	@Override
	@ExecutionTime
	@CacheEvict(cacheNames="heroes", allEntries=true)
	public void updateHero(Long id, HeroRequest heroRequest){
		Optional<Hero> hero = heroDao.findById(id);
		if(hero.isEmpty()) {
			throw new HeroNotFoundException("Not found the Hero with id: " + id); 
		} 
		Hero heroUpdate = generateHeroObject(heroRequest);
		heroUpdate.setId(id);
		heroDao.save(heroUpdate);
	}

	
	private Hero generateHeroObject(final HeroRequest heroRequest) {
		Hero hero = new Hero();
		hero.setDescription(heroRequest.getDescription());
		hero.setName(heroRequest.getName());
		return hero;
	}

}
