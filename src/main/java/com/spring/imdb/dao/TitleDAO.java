package com.spring.imdb.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.imdb.entity.GenreEntity;
import com.spring.imdb.entity.TitleEntity;

@Repository
public class TitleDAO {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public TitleEntity getTitleEntity(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TitleEntity titleEntity;
		entityManager.getTransaction().begin();
		titleEntity = entityManager.find(TitleEntity.class,id);
		entityManager.getTransaction().commit();
		return titleEntity;
	}
	
	public TitleEntity saveTitleEntity(TitleEntity titleEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(titleEntity);
		entityManager.getTransaction().commit();
		return titleEntity;
	}
	
	public TitleEntity updateTitleEntity(TitleEntity titleEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		titleEntity = entityManager.merge(titleEntity);
		entityManager.getTransaction().commit();
		return titleEntity;
	}
	
	public void removeTitleEntity(TitleEntity titleEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(titleEntity);
		entityManager.getTransaction().commit();
	}
	
	
	public TitleEntity updateTitleEntityName(TitleEntity titleEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());
		titleEntity2.setTitleName(titleEntity.getTitleName());
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return titleEntity2;
	}
	
	public TitleEntity updateTitleEntityAddGenre(TitleEntity titleEntity) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());
		
		for(GenreEntity a:titleEntity.getGenreSet()) {
			GenreEntity b = entityManager.find(GenreEntity.class,a.getGenreId());
			titleEntity2.getGenreSet().add(b);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return titleEntity2;
	}
	
	public TitleEntity updateTitleEntityRemoveGenre(TitleEntity titleEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());
		
		if(titleEntity.getGenreSet()!=null) {
			for(GenreEntity a:titleEntity.getGenreSet()) {
				GenreEntity b = entityManager.find(GenreEntity.class,a.getGenreId());
				titleEntity2.getGenreSet().remove(b);
			}
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return titleEntity2;
	}
	
	
}
