package com.spring.imdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.imdb.business.bean.MovieAndEpisode_PersonBean;
import com.spring.imdb.dao.MovieAndEpisode_PersonDAO;
import com.spring.imdb.entity.MovieAndEpisodeEntity;
import com.spring.imdb.entity.MovieAndEpisode_PersonEntity;
import com.spring.imdb.entity.PersonEntity;

@Service
public class MovieAndEpisode_PersonService {

	@Autowired
	public MovieAndEpisode_PersonDAO movieAndEpisode_PersonDAO;
	
	public void saveMovieAndEpisode_PersonBean(MovieAndEpisode_PersonBean movieAndEpisode_PersonBean) {
		movieAndEpisode_PersonDAO.saveMovieAndEpisode_PersonEntity(movieAndEpisode_PersonBean);
	}
	
}
