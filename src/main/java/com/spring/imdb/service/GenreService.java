package com.spring.imdb.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.dao.GenreDAO;
import com.spring.imdb.entity.GenreEntity;

@Service
public class GenreService {
	
	@Autowired
	public GenreDAO genreDAO;
	
	GenreEntity genreEntity;
	
	public void saveGenre(GenreBean genreBean) {
		genreEntity = new GenreEntity();
		//genreEntity.setGenreId(genreBean.genreId);
		genreEntity.setGenreName(genreBean.getGenreName());
		genreEntity.setTitleSet(null);
		genreDAO.saveGenreEntity(genreEntity);
		genreEntity = null;
	}
	
	public GenreBean getGenre(int id) {
		GenreBean genreBean = new GenreBean();
		BeanUtils.copyProperties(genreDAO.getGenreEntityById(id),genreBean);
		return genreBean;
	}
	
}
