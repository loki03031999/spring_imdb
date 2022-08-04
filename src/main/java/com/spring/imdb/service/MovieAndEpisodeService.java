package com.spring.imdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.imdb.business.bean.MovieAndEpisodeBean;
import com.spring.imdb.dao.MovieAndEpisodeDAO;
import com.spring.imdb.entity.MovieAndEpisodeEntity;

@Service
public class MovieAndEpisodeService {
	
	@Autowired
	public MovieAndEpisodeDAO movieAndEpisodeDAO;
	
	public List<MovieAndEpisodeBean> getMovieAndEpisodeList(){
		return movieAndEpisodeDAO.getMovieAndEpisodeList();
	}
	
	public int saveMovieAndEpisode(MovieAndEpisodeBean movieAndEpisodeBean) {
		System.out.println("service "+movieAndEpisodeBean);
		int a = movieAndEpisodeDAO.saveMovieAndEpisode(movieAndEpisodeBean);
		return a;
	}
	
}
