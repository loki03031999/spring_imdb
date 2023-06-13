package com.spring.imdb.service;

import com.spring.imdb.business.bean.PersonBean;
import com.spring.imdb.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public PersonBean getPersonBeanById(int personId) {
        return personDAO.getPersonEntityById(personId);
    }

    public List<PersonBean> getPersonBeanList() {
        return personDAO.getPersonEntityList();
    }

    public String savePersonBean(PersonBean personBean) {
        System.out.println("service " + personBean);
        personDAO.savePersonEntity(personBean);
        return "Person saved, Id - " + personBean.getPersonId();
    }

    public String updatePersonBean(PersonBean personBean) {
        PersonBean personBean2 = personDAO.updatePersonEntity(personBean);
        if (personBean2.getPersonId() == 0) {
            return "Person with id " + personBean.getPersonId() + " not found!!!";
        }
        return "Person with id " + personBean.getPersonId() + " updated";
    }

    public String removePersonBeanById(int personId) {
        return personDAO.removePersonEntityById(personId);
    }

}
