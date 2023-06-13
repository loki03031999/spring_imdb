package com.spring.imdb.dao;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.entity.GenreEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GenreDAO {

    @Autowired
    public EntityManagerFactory entityManagerFactory;

    public GenreEntity getGenreEntityById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        GenreEntity genreEntity = entityManager.find(GenreEntity.class, id);
        if (genreEntity == null) genreEntity = new GenreEntity();
        entityManager.close();
        return genreEntity;
    }

    public List<GenreBean> getGenreList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<GenreEntity> genreEntityList = entityManager.createQuery("select e from GenreEntity e", GenreEntity.class).getResultList();

        entityManager.close();

        List<GenreBean> genreBeanList = convertEntityToBeanList(genreEntityList);
        return genreBeanList;
    }

    public GenreEntity saveGenreEntity(GenreEntity genreEntity) {
        System.out.println(genreEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        genreEntity.setGenreId(0);
        entityManager.persist(genreEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return genreEntity;
    }

    public GenreEntity updateGenreEntity(GenreEntity genreEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        GenreEntity genreEntity2 = entityManager.find(GenreEntity.class, genreEntity.getGenreId());
        if (genreEntity2 != null) genreEntity2.setGenreName(genreEntity.getGenreName());
        entityManager.getTransaction().commit();
        entityManager.close();
        return genreEntity2;
    }

    public String deleteGenreEntity(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        GenreEntity genreEntity = entityManager.find(GenreEntity.class, id);
        if (genreEntity != null) entityManager.remove(genreEntity);
        else {
            entityManager.close();
            return "Genre not found!!";
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Genre with Id - " + genreEntity.getGenreId() + "deleted";
    }

    public static List<GenreBean> convertEntityToBeanList(List<GenreEntity> genreEntityList) {
        List<GenreBean> genreBeanList = new ArrayList<GenreBean>();
        if (genreEntityList != null) {
            for (GenreEntity a : genreEntityList) {
                GenreBean b = new GenreBean();
                BeanUtils.copyProperties(a, b);
                genreBeanList.add(b);
            }
        }
        return genreBeanList;
    }

}
