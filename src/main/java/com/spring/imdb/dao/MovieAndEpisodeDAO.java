package com.spring.imdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.spring.imdb.business.bean.MovieAndEpisodeBean;
import com.spring.imdb.entity.MovieAndEpisodeEntity;

@Repository
@Transactional
public class MovieAndEpisodeDAO {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;
	
	public List<MovieAndEpisodeBean> getMovieAndEpisodeList() {
		List<MovieAndEpisodeEntity> movieAndEpisodeEntityList =  entityManager.createQuery("select a from MovieAndEpisodeEntity a",MovieAndEpisodeEntity.class).getResultList();
		return convertEntityToBeanList(movieAndEpisodeEntityList);
	}
	
	public int saveMovieAndEpisode(MovieAndEpisodeBean movieAndEpisodeBean) {
		System.out.println("DAO  "+movieAndEpisodeBean);
		MovieAndEpisodeEntity movieAndEpisodeEntity = convertBeanToEntity(movieAndEpisodeBean);
		System.out.println("DAO entity - "+movieAndEpisodeEntity);
		entityManager.persist(movieAndEpisodeEntity);
		return movieAndEpisodeEntity.getMovieandepisodeId();
	}
	
	public static MovieAndEpisodeEntity convertBeanToEntity(MovieAndEpisodeBean movieAndEpisodeBean) {
		MovieAndEpisodeEntity movieAndEpisodeEntity = new MovieAndEpisodeEntity();
		if(movieAndEpisodeBean!=null){
			BeanUtils.copyProperties(movieAndEpisodeBean, movieAndEpisodeEntity);
			movieAndEpisodeEntity.setLanguage(movieAndEpisodeBean.getLanguages());
		}
		return movieAndEpisodeEntity;
	}	
	
	public static List<MovieAndEpisodeBean> convertEntityToBeanList(List<MovieAndEpisodeEntity> entityList) {
		List<MovieAndEpisodeBean> beanList = new ArrayList<MovieAndEpisodeBean>();
		if(entityList!=null) {
			for(MovieAndEpisodeEntity a:entityList) {
				MovieAndEpisodeBean b = new MovieAndEpisodeBean();
				BeanUtils.copyProperties(a, b);
				b.setLanguages(a.getLanguage());
				beanList.add(b);
			}
		}
		return beanList;
		
	}
}
