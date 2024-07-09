package com.example.todo_list_app.dao;


import com.example.todo_list_app.domain.UserEntity;

public interface RegistrationDao {

    UserEntity save(UserEntity userEntity);
}
