package com.hiberus.prueba;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import com.fasterxml.jackson.databind.JsonNode;
import com.hiberus.prueba.model.Hero;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HeroesRestServiceTest {
	
	 @LocalServerPort
	  int randomServerPort;

	 private TestRestTemplate testRestTemplate;

	  @BeforeEach
	  public void setUp() {
	    this.testRestTemplate = new TestRestTemplate();
	  }
	  
	  
	  @Test
	  public void create_hero() {
		  Hero hero = new Hero();
		  hero.setName("Superman");
		  hero.setDescription("Description");
		  String url = "http://localhost:8080/api/heroes";
		  Long result = this.testRestTemplate.postForObject(url, hero, Long.class);
		  assertTrue(result!=null, "dfgdf");

	  }
	  
	  @Test
	  public void find_hero_by_id() {
		  long id = 1;
		  String url = "http://localhost:8080/api/heroes/";
		  ResponseEntity<JsonNode> result = this.testRestTemplate.getForEntity(url + id, JsonNode.class);
		  assertThat(result.getStatusCode(), is(HttpStatus.OK));

	  }
	  
	  @Test
	  public void not_found_hero_by_id() {
		  long id = 100;
		  String url = "http://localhost:8080/api/heroes/";
		  ResponseEntity<JsonNode> result = this.testRestTemplate.getForEntity(url + id, JsonNode.class);
		  assertThat(result.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));

	  }
	  
	  @Test
	  public void find_all_heroes() {
		  String url = "http://localhost:8080/api/heroes";
		  ResponseEntity<JsonNode> result = this.testRestTemplate
			      .getForEntity(url, JsonNode.class);
		  assertThat(result.getStatusCode(), is(HttpStatus.OK));
	  }
}
