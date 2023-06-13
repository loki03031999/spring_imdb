package com.spring.imdb.controller;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping(path = "/id/{genreId}")
    public ResponseEntity<GenreBean> getGenreById(@PathVariable("genreId") int genreId) {
        GenreBean genreBean = genreService.getGenre(genreId);
        return new ResponseEntity<GenreBean>(genreBean, HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<GenreBean>> getGenreList() {
        List<GenreBean> genreBeanList = genreService.getGenreList();
        return new ResponseEntity<List<GenreBean>>(genreBeanList, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<GenreBean> saveGenre(@RequestBody GenreBean genreBean) {
        genreService.saveGenre(genreBean);
        return new ResponseEntity<GenreBean>(genreBean, HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<GenreBean> updateGenre(@RequestBody GenreBean genreBean) {
        genreBean = genreService.updateGenre(genreBean);
        return new ResponseEntity<GenreBean>(genreBean, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable("id") int genreId) {
        return new ResponseEntity<String>(genreService.deleteGenre(genreId), HttpStatus.OK);
    }

}
