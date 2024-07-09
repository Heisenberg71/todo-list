package com.example.todo_list_app.dao;

import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegistrationDaoImpl implements RegistrationDao {

    private final RegistrationRepository registrationRepository;
    public UserEntity save(UserEntity userEntity) {

        return registrationRepository.save(userEntity);
    }
}
