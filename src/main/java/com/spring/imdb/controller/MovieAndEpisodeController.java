package com.spring.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.imdb.business.bean.MovieAndEpisodeBean;
import com.spring.imdb.service.MovieAndEpisodeService;

@Controller
@RequestMapping(path = "/movieandepisode")
public class MovieAndEpisodeController {

	@Autowired
	public MovieAndEpisodeService movieAndEpisodeService;
	
	@GetMapping(path = "/get/list")
	public ResponseEntity<List<MovieAndEpisodeBean>> saveMovieAndEpisodeService() {
		List<MovieAndEpisodeBean> a = movieAndEpisodeService.getMovieAndEpisodeList();
		return new ResponseEntity<List<MovieAndEpisodeBean>>(a,HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<Integer> saveMovieAndEpisodeService(@RequestBody MovieAndEpisodeBean movieAndEpisodeBean) {
		
		System.out.println("controller  "+movieAndEpisodeBean);
		int a = movieAndEpisodeService.saveMovieAndEpisode(movieAndEpisodeBean);
		return new ResponseEntity<Integer>(a,HttpStatus.ACCEPTED);
	}
	
}
