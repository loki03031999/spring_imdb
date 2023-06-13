package com.spring.imdb.dao;

import com.spring.imdb.business.bean.GenreBean;
import com.spring.imdb.business.bean.TitleBean;
import com.spring.imdb.entity.GenreEntity;
import com.spring.imdb.entity.TitleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class TitleDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public TitleEntity getTitleEntity(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TitleEntity titleEntity;
        entityManager.getTransaction().begin();
        titleEntity = entityManager.find(TitleEntity.class, id);
        if (titleEntity == null) titleEntity = new TitleEntity();
        entityManager.getTransaction().commit();
        return titleEntity;
    }

    public List<TitleBean> getTitleBeanList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<TitleEntity> titleEntityList = entityManager.createQuery("select a from TitleEntity a", TitleEntity.class).getResultList();
        entityManager.close();
        List<TitleBean> titleBeanList = convertTitleEntityToTitleBeanList(titleEntityList);
        return titleBeanList;
    }

    public TitleEntity saveTitleEntity(TitleEntity titleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        titleEntity.setTitleId(0);
        entityManager.getTransaction().begin();
        entityManager.persist(titleEntity);
        entityManager.getTransaction().commit();
        return titleEntity;
    }

    public TitleEntity updateTitleEntity(TitleEntity titleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());
        if (titleEntity2 == null) return new TitleEntity();
        BeanUtils.copyProperties(titleEntity, titleEntity2);
        entityManager.getTransaction().commit();
        return titleEntity2;
    }

    public TitleEntity updateTitleEntityName(TitleEntity titleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());
        if (titleEntity2 != null) titleEntity2.setTitleName(titleEntity.getTitleName());
        else titleEntity2 = new TitleEntity();
        entityManager.getTransaction().commit();
        entityManager.close();
        return titleEntity2;
    }

    public TitleEntity updateTitleEntityAddGenre(TitleEntity titleEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());

        if (titleEntity2 != null && titleEntity.getGenreSet() != null) {
            for (GenreEntity a : titleEntity.getGenreSet()) {
                GenreEntity b = entityManager.find(GenreEntity.class, a.getGenreId());
                titleEntity2.getGenreSet().add(b);
            }
        } else titleEntity2 = new TitleEntity();
        entityManager.getTransaction().commit();
        entityManager.close();
        return titleEntity2;
    }

    public TitleEntity updateTitleEntityRemoveGenre(TitleEntity titleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TitleEntity titleEntity2 = entityManager.find(TitleEntity.class, titleEntity.getTitleId());

        if (titleEntity2 != null && titleEntity.getGenreSet() != null) {
            for (GenreEntity a : titleEntity.getGenreSet()) {
                GenreEntity b = entityManager.find(GenreEntity.class, a.getGenreId());
                titleEntity2.getGenreSet().remove(b);
            }
        } else titleEntity2 = new TitleEntity();
        entityManager.getTransaction().commit();
        entityManager.close();
        return titleEntity2;
    }


    public String removeTitleEntity(int titleId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TitleEntity titleEntity = entityManager.find(TitleEntity.class, titleId);
        if (titleEntity != null) entityManager.remove(titleEntity);
        else return "Entity Not Found!!";
        entityManager.getTransaction().commit();
        return "Entity Deleted with ID - " + titleEntity.getTitleId();
    }


    public static List<TitleBean> convertTitleEntityToTitleBeanList(List<TitleEntity> titleEntityList) {
        List<TitleBean> titleBeanList = new ArrayList<TitleBean>();

        if (titleEntityList != null) {
            for (TitleEntity a : titleEntityList) {
                TitleBean b = convertEntityToBean(a);
                titleBeanList.add(b);
            }
        }
        return titleBeanList;
    }

    public static TitleBean convertEntityToBean(TitleEntity titleEntity) {
        TitleBean titleBean = new TitleBean();

        titleBean.setTitleId(titleEntity.getTitleId());
        titleBean.setTitleName(titleEntity.getTitleName());

        Set<GenreEntity> genreEntitySet = titleEntity.getGenreSet();
        //System.out.println(genreEntitySet);
        Set<GenreBean> genreBeanSet = new HashSet<GenreBean>();
        if (genreEntitySet != null) {
            for (GenreEntity genreEntity : genreEntitySet) {
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

        if (genreBeanGenreSet != null) {
            for (GenreBean genreBean : genreBeanGenreSet) {
                GenreEntity genreEntity = new GenreEntity();
                BeanUtils.copyProperties(genreBean, genreEntity);
                genreEntityGenreSet.add(genreEntity);
            }
        }
        titleEntity.setGenreSet(genreEntityGenreSet);
        return titleEntity;
    }

}
