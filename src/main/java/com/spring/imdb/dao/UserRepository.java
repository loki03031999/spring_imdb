package com.spring.imdb.dao;

import com.spring.imdb.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u")
    public List<User> listAllUsers();

    @Query("select u from User u where u.secureUserId = ?1")
    public Optional<User> getUserBySecureUserId(String secureUserId);
}
