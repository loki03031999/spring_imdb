package com.spring.imdb.dao;

import com.spring.imdb.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u")
    public List<User> listAllUsers();
}
