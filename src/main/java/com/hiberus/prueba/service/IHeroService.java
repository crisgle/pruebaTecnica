package com.hiberus.prueba.service;

import java.util.List;

import com.hiberus.prueba.exception.HeroNotFoundException;
import com.hiberus.prueba.model.Hero;
import com.hiberus.prueba.model.HeroRequest;

public interface IHeroService {

	public List<Hero> getAllHero();
	
	public Hero getHeroById(final Long id);
	
	public List<Hero> getHeroesByName(final String name);
	
	public void deleteHero(final Long id);
	
	public Long createHero(final HeroRequest heroRequest);
	
	public void updateHero(final Long id, final HeroRequest heroRequest);
}
