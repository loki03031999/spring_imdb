package com.spring.imdb.controller;

import com.spring.imdb.entity.User;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String password;

    public User getUser() {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }
}
