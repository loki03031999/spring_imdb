package com.spring.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@DeleteMapping(path="/delete")
	public ResponseEntity<String> deleteMovieAndEpisodeService(@RequestParam("id") Integer id ){
		id = movieAndEpisodeService.deleteMovieAndEpisode(id);
		if(id!=0)	return new ResponseEntity<String>("MovieAndEpisode with id "+id,HttpStatus.OK);
		else return new ResponseEntity<String>("Some Error Occured",HttpStatus.BAD_REQUEST);
	}
	
}
