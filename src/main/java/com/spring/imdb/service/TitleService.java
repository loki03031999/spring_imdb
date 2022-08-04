package com.spring.imdb.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.business.bean.TitleBean;
import com.spring.imdb.dao.TitleDAO;
import com.spring.imdb.entity.GenreEntity;
import com.spring.imdb.entity.TitleEntity;

@Service
public class TitleService {

	@Autowired
	public TitleDAO titleDAO;
	
	public TitleBean getTitleBeanById(int id) {
		TitleBean titleBean = new TitleBean();
		TitleEntity titleEntity = titleDAO.getTitleEntity(id);
		titleBean = convertEntityToBean(titleEntity);
		//BeanUtils.copyProperties(titleEntity, titleBean);
		System.out.println(titleBean);
		return titleBean;
	}
	
	public List<TitleBean> getTitleBeanList(){
		List<TitleBean> titleBeanList = titleDAO.getTitleBeanList();
		return titleBeanList;
	}
	
	public TitleBean saveTitleBean(TitleBean titleBean) {
		TitleEntity titleEntity = new TitleEntity();
		System.out.println(titleBean);
		//BeanUtils.copyProperties(titleBean, titleEntity);
		titleEntity = convertBeanToEntity(titleBean);
		titleDAO.saveTitleEntity(titleEntity);
		titleBean = convertEntityToBean(titleEntity);
		return titleBean;
	}
	
	public int updateTitleBean(TitleBean titleBean) {
		TitleEntity titleEntity = new TitleEntity();
		//BeanUtils.copyProperties(titleBean, titleEntity);
		titleEntity = convertBeanToEntity(titleBean);
		titleDAO.updateTitleEntity(titleEntity);
		return titleEntity.getTitleId();
	}
	
	/* 
	 * update title name only 
	 * */
	public TitleBean updateTitleNameOnly(TitleBean titleBean) {
		TitleEntity titleEntity = convertBeanToEntity(titleBean);
		return convertEntityToBean(titleDAO.updateTitleEntityName(titleEntity));
	}
	
	public TitleBean updateTitleGenreAdd(TitleBean titleBean) {
		TitleEntity titleEntity = convertBeanToEntity(titleBean);
		return convertEntityToBean(titleDAO.updateTitleEntityAddGenre(titleEntity));
	}
	
	public TitleBean updateTitleRemoveGenre(TitleBean titleBean) {
		TitleEntity titleEntity = convertBeanToEntity(titleBean);
		return convertEntityToBean(titleDAO.updateTitleEntityRemoveGenre(titleEntity));
	}
	
	
	public String removeTitle(int titleId) {
		return titleDAO.removeTitleEntity(titleId);
	}
	
	
	public static TitleBean convertEntityToBean(TitleEntity titleEntity) {
		TitleBean titleBean = new TitleBean();
		
		titleBean.setTitleId(titleEntity.getTitleId());
		titleBean.setTitleName(titleEntity.getTitleName());
		
		Set<GenreEntity> genreEntitySet = titleEntity.getGenreSet();
		//System.out.println(genreEntitySet);
		Set<GenreBean> genreBeanSet = new HashSet<GenreBean>();
		if(genreEntitySet!=null) {
			for(GenreEntity genreEntity:genreEntitySet) {
				GenreBean genreBean = new GenreBean();
				BeanUtils.copyProperties(genreEntity, genreBean);
				genreBeanSet.add(genreBean);
			}
		}
		titleBean.setGenreSet(genreBeanSet);
		return titleBean;
	}
	
	public static TitleEntity convertBeanToEntity(TitleBean titleBean) {
		TitleEntity titleEntity = new TitleEntity();
		
		titleEntity.setTitleName(titleBean.getTitleName());
		titleEntity.setTitleId(titleBean.getTitleId());
		Set<GenreBean> genreBeanGenreSet = titleBean.getGenreSet();
		Set<GenreEntity> genreEntityGenreSet = new HashSet<GenreEntity>(); 
		
		if(genreBeanGenreSet!=null) {
			for(GenreBean genreBean:genreBeanGenreSet) {
				GenreEntity genreEntity = new GenreEntity();
				BeanUtils.copyProperties(genreBean, genreEntity);
				genreEntityGenreSet.add(genreEntity);
			}
		}
		titleEntity.setGenreSet(genreEntityGenreSet);		
		return titleEntity;
	}
}
