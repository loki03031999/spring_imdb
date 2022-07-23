package com.spring.imdb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Genre {
	
	@GetMapping(path="/genreList")
	public String getGenre() {
		return "this is genre";
	}
	
}
