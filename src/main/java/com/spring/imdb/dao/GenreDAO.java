package com.spring.imdb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.imdb.entity.GenreEntity;

@Repository
public class GenreDAO {
	
	@Autowired
	public EntityManagerFactory entityManagerFactory;
	
	public GenreEntity getGenreEntityById(int id) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		GenreEntity genreEntity  = entityManager.find(GenreEntity.class, id);
		entityManager.close();
		return genreEntity;	
	}
	
	public void saveGenreEntity(GenreEntity genreEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(genreEntity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return;
	}
	
}
