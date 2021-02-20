package com.hiberus.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hiberus.prueba.dao.IHeroDao;
import com.hiberus.prueba.exception.HeroNotFoundException;
import com.hiberus.prueba.model.Hero;
import com.hiberus.prueba.model.HeroRequest;
import com.hiberus.prueba.service.HeroService;

class HeroServiceUnitTest {
	
	@Test
	public void find_all_heroes_ok() throws HeroNotFoundException {
		IHeroDao daoMock = Mockito.mock(IHeroDao.class);  
		Mockito.when(daoMock.findById(Mockito.any(Long.class))).thenReturn(generateHero());
		Hero hero = new HeroService(daoMock).getHeroById(Long.valueOf("1"));
		assertEquals(hero.getName(), "Superman");
	}
	
	@Test
	public void create_hero_ok() {
		IHeroDao daoMock = Mockito.mock(IHeroDao.class);  
		Mockito.when(daoMock.save(Mockito.any(Hero.class))).thenReturn(generateHero().get());
		Long id = new HeroService(daoMock).createHero(generateHeroRequest());
		assertEquals(id!=null, true);
	}
	
	
	private Optional<Hero> generateHero() {
		Hero hero = new Hero();
		hero.setId(Long.valueOf("1"));
		hero.setName("Superman");
		hero.setDescription("Description Superman");
		return Optional.of(hero);
	}
	
	private HeroRequest generateHeroRequest() {
		HeroRequest request = new HeroRequest();
		request.setName("Superman");
		request.setDescription("Description");
		return request;
	}

}
