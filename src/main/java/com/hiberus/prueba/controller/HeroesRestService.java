package com.hiberus.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.prueba.model.Hero;
import com.hiberus.prueba.model.HeroRequest;
import com.hiberus.prueba.service.IHeroService;

@RestController
@RequestMapping("/api/heroes")
public class HeroesRestService {
	
	@Autowired
	private IHeroService heroService;
	
	@GetMapping
	public ResponseEntity<List<Hero>> getHeroes(){
		return ResponseEntity.ok(heroService.getAllHero());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Hero> getHeroById(@PathVariable("id") Long id){
		return ResponseEntity.ok(heroService.getHeroById(id));
	}

	@GetMapping(value="filter/{name}")
	public ResponseEntity<List<Hero>> getHeroesByName(@PathVariable("name") String name){
		return ResponseEntity.ok(heroService.getHeroesByName(name));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteHero(@PathVariable("id") Long id){
		heroService.deleteHero(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<Long> createHero(@RequestBody HeroRequest heroRequest){
		Long id = heroService.createHero(heroRequest);
		return ResponseEntity.ok(id);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> updateHero(@PathVariable("id") Long id, @Validated @RequestBody HeroRequest heroRequest) {
			heroService.updateHero(id, heroRequest);
			return ResponseEntity.ok().build();
		}
		
	}

