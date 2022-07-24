package com.spring.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.entity.GenreEntity;
import com.spring.imdb.service.GenreService;

@RestController
public class GenreController {
	
	@Autowired
	GenreService genreService;
	
	@GetMapping(path="/genre/id/{genreId}")
	public ResponseEntity<GenreEntity> getGenreById(@PathVariable("genreId") int genreId) {
		return new ResponseEntity<GenreEntity>( genreService.getGenre(genreId),HttpStatus.OK);
	}
	
	@PostMapping(path="/genre/save")
	public ResponseEntity<GenreBean> saveGenre(@RequestBody GenreBean genreBean){
		genreService.saveGenre(genreBean);
		return new ResponseEntity<GenreBean>(genreBean,HttpStatus.OK);
	}
	
}
