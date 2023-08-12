package com.spring.imdb.controller;

import com.mysql.cj.util.StringUtils;
import com.spring.imdb.dao.UserManager;
import com.spring.imdb.entity.User;
import com.spring.imdb.exceptions.DataException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserManager userManager;

    @GetMapping(path = "/{userId}")
    private ResponseEntity<UserResponse> getUserWithSecureUserId(@PathVariable("userId") String userId) {
        //Request Validation
        if (StringUtils.isEmptyOrWhitespaceOnly(userId)) {
            logger.error("Invalid request received for GET/user, error: Invalid userId");
            return ResponseEntity
                    .badRequest()
                    .body(UserResponse.createBadRequestErrorResponse("userId cannot be null or blank"));
        }

        try {
            User user = userManager.getUserBySecureUserId(userId);
            return ResponseEntity
                    .ok(UserResponse.createResponse(user));
        }
        catch (DataException dataException) {
            return ResponseEntity
                    .status(dataException.getStatus())
                    .body(UserResponse.createErrorResponse(dataException));
        }
    }

    @PostMapping
    private ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        //Request Validation
        Optional<UserResponse> validationResult = validatePostRequest(userRequest);
        if (validationResult.isPresent()) {
            return ResponseEntity.badRequest().body(validationResult.get());
        }

        try {
            User user = userManager.save(userRequest.getUser());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(UserResponse.createCreationResponse(user));
        }
        catch (DataException dataException) {
            return ResponseEntity
                    .status(dataException.getStatus())
                    .body(UserResponse.createErrorResponse(dataException));
        }
    }

    private Optional<UserResponse> validatePostRequest(UserRequest userRequest) {
        UserResponse userResponse = null;
        if (userRequest == null) {
            userResponse = UserResponse.createBadRequestErrorResponse("unable to parse request");
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(userRequest.getName())) {
            userResponse = UserResponse.createBadRequestErrorResponse("invalid name");
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(userRequest.getPassword())) {
            userResponse = UserResponse.createBadRequestErrorResponse("invalid password");
        }
        return Optional.ofNullable(userResponse);
    }

}
