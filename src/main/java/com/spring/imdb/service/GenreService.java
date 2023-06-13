package com.spring.imdb.service;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.dao.GenreDAO;
import com.spring.imdb.entity.GenreEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    public GenreDAO genreDAO;

    public GenreBean getGenre(int id) {
        GenreBean genreBean = new GenreBean();
        BeanUtils.copyProperties(genreDAO.getGenreEntityById(id), genreBean);
        return genreBean;
    }

    public List<GenreBean> getGenreList() {
        return genreDAO.getGenreList();
    }

    public GenreBean saveGenre(GenreBean genreBean) {
        GenreEntity genreEntity = new GenreEntity();
        //genreEntity.setGenreId(genreBean.genreId);
        BeanUtils.copyProperties(genreBean, genreEntity);
        genreEntity = genreDAO.saveGenreEntity(genreEntity);
        BeanUtils.copyProperties(genreEntity, genreBean);
        return genreBean;
    }

    public GenreBean updateGenre(GenreBean genreBean) {
        GenreEntity genreEntity = new GenreEntity();
        BeanUtils.copyProperties(genreBean, genreEntity);
        genreDAO.updateGenreEntity(genreEntity);
        BeanUtils.copyProperties(genreEntity, genreBean);
        return genreBean;
    }

    public String deleteGenre(int genreId) {
        return genreDAO.deleteGenreEntity(genreId);
    }

}
