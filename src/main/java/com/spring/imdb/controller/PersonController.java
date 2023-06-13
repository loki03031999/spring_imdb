package com.spring.imdb.controller;

import com.spring.imdb.business.bean.PersonBean;
import com.spring.imdb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(path = "/get")
    public ResponseEntity<PersonBean> getPersonById(@RequestParam("personid") int personId) {
        PersonBean personBean = personService.getPersonBeanById(personId);
        return new ResponseEntity<PersonBean>(personBean, HttpStatus.OK);
    }

    @GetMapping(path = "/get/list")
    public ResponseEntity<List<PersonBean>> getPersonList() {
        List<PersonBean> personBeanList = personService.getPersonBeanList();
        return new ResponseEntity<List<PersonBean>>(personBeanList, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> savePerson(@RequestBody PersonBean personBean) {
        System.out.println("controller " + personBean);
        String message = personService.savePersonBean(personBean);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<String> updatePerson(@RequestBody PersonBean personBean) {
        String message = personService.updatePersonBean(personBean);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> removePersonById(@RequestParam("personid") int personId) {
        String message = personService.removePersonBeanById(personId);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
