package com.spring.imdb.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.imdb.entity.User;
import com.spring.imdb.exceptions.DataException;
import lombok.Data;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String userId;
    private String name;
    private String errorCode;
    private String errorMessage;

    public static UserResponse createResponse(@NonNull User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getSecureUserId());
        userResponse.setName(user.getName());
        return userResponse;
    }

    public static UserResponse createCreationResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getSecureUserId());
        return userResponse;
    }

    public static UserResponse createErrorResponse(DataException dataException) {
        UserResponse userResponse = new UserResponse();
        userResponse.setErrorCode(dataException.getDataExceptionErrorCode().name());
        userResponse.setErrorMessage(dataException.getMessage());
        return userResponse;
    }

    public static UserResponse createBadRequestErrorResponse(String errorMessage) {
        UserResponse userResponse = new UserResponse();
        userResponse.setErrorMessage(errorMessage);
        userResponse.setErrorCode(HttpStatus.BAD_REQUEST.toString());
        return userResponse;
    }

}
