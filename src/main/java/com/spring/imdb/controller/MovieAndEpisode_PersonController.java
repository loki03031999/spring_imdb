package com.spring.imdb.controller;

import com.spring.imdb.business.bean.MovieAndEpisode_PersonBean;
import com.spring.imdb.service.MovieAndEpisode_PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/movieandepisodeperson")
public class MovieAndEpisode_PersonController {

    @Autowired
    MovieAndEpisode_PersonService movieAndEpisode_PersonService;

    @PostMapping(path = "/save")
    public void saveMovieAndEpisode_Person(@RequestBody MovieAndEpisode_PersonBean movieAndEpisode_PersonBean) {
        movieAndEpisode_PersonService.saveMovieAndEpisode_PersonBean(movieAndEpisode_PersonBean);
    }

    @DeleteMapping(path = "/delete")
    public void deleteMovieAndEpisode_Person(@RequestBody MovieAndEpisode_PersonBean movieAndEpisode_PersonBean) {
        movieAndEpisode_PersonService.deleteMovieAndEpisode_PersonEntity(movieAndEpisode_PersonBean);
    }

}
