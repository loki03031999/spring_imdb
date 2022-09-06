package com.spring.imdb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.spring.imdb.business.bean.MovieAndEpisode_PersonBean;
import com.spring.imdb.entity.MovieAndEpisodeEntity;
import com.spring.imdb.entity.MovieAndEpisode_PersonEntity;
import com.spring.imdb.entity.MovieAndEpisode_PersonKey;
import com.spring.imdb.entity.PersonEntity;

@Repository
public class MovieAndEpisode_PersonDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void saveMovieAndEpisode_PersonEntity(MovieAndEpisode_PersonBean movieAndEpisode_PersonBean) {
		MovieAndEpisode_PersonEntity movieAndEpisode_PersonEntity = new MovieAndEpisode_PersonEntity();
		MovieAndEpisodeEntity movieAndEpisodeEntity = entityManager.find(MovieAndEpisodeEntity.class, movieAndEpisode_PersonBean.getMovieAndEpisodeId());
		PersonEntity personEntity =  entityManager.find(PersonEntity.class, movieAndEpisode_PersonBean.getPersonId());
		
		movieAndEpisode_PersonEntity = convertBeanToEntity(movieAndEpisode_PersonBean, movieAndEpisodeEntity, personEntity);
		entityManager.persist(movieAndEpisode_PersonEntity);
	}
	
	//@Transactional(value = TxType.REQUIRED)
	public static MovieAndEpisode_PersonEntity convertBeanToEntity(MovieAndEpisode_PersonBean movieAndEpisode_PersonBean,MovieAndEpisodeEntity movieAndEpisodeEntity,PersonEntity personEntity) {
		MovieAndEpisode_PersonEntity movieAndEpisode_PersonEntity = new MovieAndEpisode_PersonEntity();
		MovieAndEpisode_PersonKey movieAndEpisode_PersonKey = new MovieAndEpisode_PersonKey();
		movieAndEpisode_PersonKey.setMovieAndEpisodeId(movieAndEpisode_PersonBean.getMovieAndEpisodeId());
		movieAndEpisode_PersonKey.setPersonId(movieAndEpisode_PersonBean.getPersonId());
		movieAndEpisode_PersonEntity.setId(movieAndEpisode_PersonKey);
		movieAndEpisode_PersonEntity.setNameInMovie(movieAndEpisode_PersonBean.getNameInMovie());
		movieAndEpisode_PersonEntity.setWorkedAs(movieAndEpisode_PersonBean.getWorkedAs());
		movieAndEpisode_PersonEntity.setMovieandepisode(movieAndEpisodeEntity);
		movieAndEpisode_PersonEntity.setPerson(personEntity);
		return movieAndEpisode_PersonEntity;
	}
	
	@Transactional
	public void deleteMovieAndEpisode_PersonEntity(MovieAndEpisode_PersonBean movieAndEpisode_PersonBean) {
		
		//MovieAndEpisode_PersonEntity movieAndEpisode_PersonEntity = convertBeanToEntity(movieAndEpisode_PersonBean, null, null);
		MovieAndEpisode_PersonKey movieAndEpisode_PersonKey = new MovieAndEpisode_PersonKey();
		movieAndEpisode_PersonKey.setMovieAndEpisodeId(movieAndEpisode_PersonBean.getMovieAndEpisodeId());
		movieAndEpisode_PersonKey.setPersonId(movieAndEpisode_PersonBean.getPersonId());
		MovieAndEpisode_PersonEntity movieAndEpisode_PersonEntity = entityManager.find(MovieAndEpisode_PersonEntity.class, movieAndEpisode_PersonKey);
		entityManager.remove(movieAndEpisode_PersonEntity);
	}
	
}
