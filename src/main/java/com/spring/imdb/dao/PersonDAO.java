package com.spring.imdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.imdb.business.bean.PersonBean;
import com.spring.imdb.entity.PersonEntity;

@Repository
@Transactional
public class PersonDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public PersonBean getPersonEntityById(int personId) {
		
		PersonEntity personEntity = entityManager.find(PersonEntity.class, personId);
		PersonBean personBean = new PersonBean();
		
		if(personEntity!=null) {
			BeanUtils.copyProperties(personEntity, personBean);
		}
		
		return personBean;
	}
	
	public List<PersonBean> getPersonEntityList() {
		List<PersonEntity> personEntityList =   entityManager.createQuery("select a from PersonEntity a",PersonEntity.class).getResultList();
		List<PersonBean> personBeanList = convertPersonEntityToPersonBeanList(personEntityList);
		return personBeanList;
	}
	
	public PersonBean savePersonEntity(PersonBean personBean) {
		PersonEntity personEntity = new PersonEntity();
		BeanUtils.copyProperties(personBean, personEntity);
		System.out.println(personBean.country);
		System.out.println(personEntity.country);
		personEntity.setPersonId(0); // making sure if id entered by user does not interfere with the operations;
		entityManager.persist(personEntity);
		personBean.setPersonId(personEntity.getPersonId());
		return personBean;
	}
	
	public PersonBean updatePersonEntity(PersonBean personBean) {
		
		PersonEntity personEntity2 = entityManager.find(PersonEntity.class,personBean.getPersonId());
		if(personEntity2!=null) {
			personEntity2 = entityManager.find(PersonEntity.class,personBean.getPersonId());
			int id = personEntity2.getPersonId();
			BeanUtils.copyProperties(personBean, personEntity2);
			personEntity2.setPersonId(id);
			entityManager.merge(personEntity2);
		}
		else {
			personBean.setPersonId(0);
		}
		
		return personBean;
	}
	
	public String removePersonEntityById(int personId) {
		PersonEntity personEntity = entityManager.find(PersonEntity.class,personId);
		if(personEntity!=null) {
			entityManager.remove(personEntity);
			return "Person with id - "+personId+" deleted";
		}
		return "Person with id "+personId+" not found!!!";
	}	
	
	public static List<PersonBean> convertPersonEntityToPersonBeanList(List<PersonEntity> personEntityList){
		List<PersonBean> personBeanList = new ArrayList<PersonBean>();
		for(PersonEntity a:personEntityList) {
			PersonBean b = new PersonBean();
			BeanUtils.copyProperties(a, b);
			personBeanList.add(b);
		}
		return personBeanList;
	}
	
	public static List<PersonEntity> convertPersonBeanToPersonEntityList(List<PersonBean> personBeanList){
		List<PersonEntity> personEntityList = new ArrayList<PersonEntity>();
		for(PersonBean a:personBeanList) {
			PersonEntity b = new PersonEntity();
			BeanUtils.copyProperties(a, b);
			personEntityList.add(b);
		}
		return personEntityList;
	}
	
	public static PersonBean convertPersonEntityToPersonBean(PersonEntity personEntity) {
		PersonBean personBean = new PersonBean();
		BeanUtils.copyProperties(personEntity, personBean);
		return personBean;
	}
	
}
