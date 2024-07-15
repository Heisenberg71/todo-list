package com.example.todo_list_app.service;

import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.request.AuthenticationRequest;
import com.example.todo_list_app.response.AuthenticationTokenResponse;

import java.util.List;

public interface LoginService {

    AuthenticationTokenResponse authenticateUser(AuthenticationRequest authenticationRequest);

    List<UserEntity> getAllUsers();
}
