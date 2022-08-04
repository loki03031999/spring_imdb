package com.spring.imdb.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class MovieAndEpisodeDAOTest {
	
	@Autowired
	public MovieAndEpisodeDAO movieAndEpisodeDAO;
	
	@Test
	public void testEntityManager() {
		Assert.notNull(movieAndEpisodeDAO, "movieAndEpisodeDAO class should not be null");
	}
	
}
