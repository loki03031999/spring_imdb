package com.spring.imdb.service;

import com.spring.imdb.business.bean.MovieAndEpisodeBean;
import com.spring.imdb.dao.MovieAndEpisodeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieAndEpisodeService {

    @Autowired
    public MovieAndEpisodeDAO movieAndEpisodeDAO;

    public List<MovieAndEpisodeBean> getMovieAndEpisodeList() {
        return movieAndEpisodeDAO.getMovieAndEpisodeList();
    }

    public int saveMovieAndEpisode(MovieAndEpisodeBean movieAndEpisodeBean) {
        System.out.println("service " + movieAndEpisodeBean);
        int a = movieAndEpisodeDAO.saveMovieAndEpisode(movieAndEpisodeBean);
        return a;
    }

    public int deleteMovieAndEpisode(int id) {
        try {
            movieAndEpisodeDAO.deleteMovieAndEpisode(id);
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            return 0;
        }
        return id;
    }

}
