package com.example.todo_list_app.dao;


import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.request.AuthenticationRequest;

import java.util.List;

public interface RegistrationDao {

    UserEntity save(UserEntity userEntity);
    
    boolean isUserValid(AuthenticationRequest authenticationRequest);

    UserEntity saveToken(AuthenticationRequest authenticationRequest, String token);

    List<UserEntity> getAllUsers();
}
