package com.spring.imdb.dao;

import com.spring.imdb.business.bean.MovieAndEpisodeAndActorsBean;
import com.spring.imdb.business.bean.MovieAndEpisodeBean;
import com.spring.imdb.business.bean.PersonBean;
import com.spring.imdb.entity.MovieAndEpisodeEntity;
import com.spring.imdb.entity.PersonEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class MovieAndEpisodeDAO {

    @PersistenceContext
    EntityManager entityManager;

    public List<MovieAndEpisodeBean> getMovieAndEpisodeList() {
        List<MovieAndEpisodeEntity> movieAndEpisodeEntityList = entityManager.createQuery("select a from MovieAndEpisodeEntity a", MovieAndEpisodeEntity.class).getResultList();
        return convertEntityToBeanList(movieAndEpisodeEntityList);
    }

//	public List<MovieAndEpisodeAndActorsBean> getMovieAndEpisodeAndActorsBeans(){
//		List<MovieAndEpisodeEntity> movieAndEpisodeEntityList =  entityManager.createQuery("select a from MovieAndEpisodeEntity a",MovieAndEpisodeEntity.class).getResultList();
//		return 
//	}

    public int saveMovieAndEpisode(MovieAndEpisodeBean movieAndEpisodeBean) {
        System.out.println("DAO  " + movieAndEpisodeBean);
        MovieAndEpisodeEntity movieAndEpisodeEntity = convertBeanToEntity(movieAndEpisodeBean);
        System.out.println("DAO entity - " + movieAndEpisodeEntity);
        entityManager.persist(movieAndEpisodeEntity);
        return movieAndEpisodeEntity.getMovieandepisodeId();
    }

    public int deleteMovieAndEpisode(int id) throws Exception {

        MovieAndEpisodeEntity movieAndEpisodeEntity = entityManager.find(MovieAndEpisodeEntity.class, id);
        entityManager.remove(movieAndEpisodeEntity);
        return id;
    }

    public static MovieAndEpisodeEntity convertBeanToEntity(MovieAndEpisodeBean movieAndEpisodeBean) {
        MovieAndEpisodeEntity movieAndEpisodeEntity = new MovieAndEpisodeEntity();
        if (movieAndEpisodeBean != null) {
            BeanUtils.copyProperties(movieAndEpisodeBean, movieAndEpisodeEntity);
            movieAndEpisodeEntity.setLanguage(movieAndEpisodeBean.getLanguages());
        }
        return movieAndEpisodeEntity;
    }

    public static List<MovieAndEpisodeBean> convertEntityToBeanList(List<MovieAndEpisodeEntity> entityList) {
        List<MovieAndEpisodeBean> beanList = new ArrayList<MovieAndEpisodeBean>();
        if (entityList != null) {
            for (MovieAndEpisodeEntity a : entityList) {
                MovieAndEpisodeBean b = new MovieAndEpisodeBean();
                BeanUtils.copyProperties(a, b);
                b.setLanguages(a.getLanguage());
                beanList.add(b);
            }
        }
        return beanList;

    }

    public static List<MovieAndEpisodeAndActorsBean> convertEntityToMovieAndEpisodeAndActorsBeanList(List<MovieAndEpisodeEntity> entityList) {
        List<MovieAndEpisodeAndActorsBean> beanList = new ArrayList<MovieAndEpisodeAndActorsBean>();
        if (entityList != null) {
            for (MovieAndEpisodeEntity a : entityList) {
                MovieAndEpisodeAndActorsBean b = new MovieAndEpisodeAndActorsBean();
                BeanUtils.copyProperties(a, b);
                b.setLanguages(a.getLanguage());
                beanList.add(b);
            }
        }
        return beanList;

    }

    public static void convertEntityToMovieAndEpisodeAndActorsBean(MovieAndEpisodeEntity movieAndEpisodeEntity) {
        MovieAndEpisodeAndActorsBean a = new MovieAndEpisodeAndActorsBean();
        BeanUtils.copyProperties(movieAndEpisodeEntity, a);
        Set<PersonBean> personBeanSet = new HashSet<PersonBean>();
        personBeanSet.addAll(PersonDAO.convertPersonEntityToPersonBeanList(new ArrayList<PersonEntity>(movieAndEpisodeEntity.getPersonSet())));
        a.setPersonBean(personBeanSet);
    }

}
