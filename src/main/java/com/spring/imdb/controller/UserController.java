package com.spring.imdb.controller;

import com.spring.imdb.dao.UserRepository;
import com.spring.imdb.entity.User;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> listUser() {
        userRepository.listAllUsers();
        return ResponseEntity.ok(userRepository.listAllUsers());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
