package com.example.todo_list_app.service;

import com.example.todo_list_app.dao.RegistrationDao;
import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.request.RegistrationRequest;
import com.example.todo_list_app.response.RegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationDao registrationDao;

    @Override
    public RegistrationResponse registerUser(RegistrationRequest registrationRequest) {

        if(!registrationRequest.getPassword().equals(registrationRequest.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match.");
        }

        UserEntity userEntity = UserEntity.builder()
                .username(registrationRequest.getUsername())
                .email(registrationRequest.getEmail())
                .password(registrationRequest.getPassword())
                .build();

        System.out.println(registrationDao.save(userEntity));

        return RegistrationResponse.builder()
                .message("User registered successfully")
                .build();
    }
}
