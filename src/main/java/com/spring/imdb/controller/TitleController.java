package com.spring.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.imdb.business.bean.TitleBean;
import com.spring.imdb.entity.TitleEntity;
import com.spring.imdb.service.TitleService;

@RestController
@RequestMapping(path = "/title")
public class TitleController {
	
	@Autowired
	TitleService titleService;
	
	@GetMapping(path = "/id")
	public ResponseEntity<TitleBean> getTitleById(@RequestParam(name = "titleid") int titleId){
		//return new ResponseBody<TitleBean>();
		TitleBean titleBean = titleService.getTitleBeanById(titleId);
		return new ResponseEntity<TitleBean>(titleBean,HttpStatus.OK);
	}
	
	/*
	 Saving New Title in Database
	 Parameters passed - 
	 	titleName
	 	listofGenres with genreId, genreName;
	 * */
	@PostMapping(path = "/save")
	public ResponseEntity<TitleBean> saveTitle(@RequestBody TitleBean titleBean){
		//return new ResponseBody<TitleBean>();
		int titleId = titleService.saveTitleBean(titleBean);
		titleBean.setTitleId(titleId);
		return new ResponseEntity<TitleBean>(titleBean,HttpStatus.OK);
	}
	
	/*
	 Updating Title in Database
	 Parameters passed - 
	 	titleId
	 	titleName
	 	listofGenres with genreId, genreName;
	 * */
	@PostMapping(path = "/update")
	public ResponseEntity<TitleBean> updateTitle(@RequestBody TitleBean titleBean){
		int titleId = titleService.updateTitleBean(titleBean);
		titleBean.setTitleId(titleId);
		return new ResponseEntity<TitleBean>(titleBean,HttpStatus.OK);
	}
	
	@PostMapping(path = "/update/titlename")
	public ResponseEntity<TitleBean> updateTitleNameOnly(@RequestBody TitleBean titleBean) {
		titleBean = titleService.updateTitleNameOnly(titleBean);
		return new ResponseEntity<TitleBean>(titleBean,HttpStatus.OK);
	}
	
	@PostMapping(path = "/update/addgenre")
	public ResponseEntity<TitleBean> updateTitleAddGenre(@RequestBody TitleBean titleBean) {
		titleBean = titleService.updateTitleGenreAdd(titleBean);
		return new ResponseEntity<TitleBean>(titleBean,HttpStatus.OK);
	}
	
	@PostMapping(path = "/update/removegenre")
	public ResponseEntity<TitleBean> updateTitleRemoveGenre(@RequestBody TitleBean titleBean) {
		titleBean = titleService.updateTitleRemoveGenre(titleBean);
		return new ResponseEntity<TitleBean>(titleBean,HttpStatus.OK);
	}
	
	/*
	 Cases - 
	 1. create a new title - parameters titleName
	 2. update a title name only - parameters titleid, new titleName and make sure genreSet remains same.
	 3. add genre only - parameters titleid, genreid 
	 4. remove certain genre parameters titleid, and genreid 
	 5. remove title make sure genre is not removed only the relation is.
	 
	 
	 * */
}
