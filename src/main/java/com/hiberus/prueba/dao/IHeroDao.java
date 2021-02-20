package com.hiberus.prueba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.prueba.model.Hero;

public interface IHeroDao extends JpaRepository<Hero, Long> {
	
	public List<Hero> findByNameLike(String name);

}
