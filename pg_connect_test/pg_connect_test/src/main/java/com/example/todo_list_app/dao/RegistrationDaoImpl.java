package com.example.todo_list_app.dao;

import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.repository.RegistrationRepository;
import com.example.todo_list_app.request.AuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RegistrationDaoImpl implements RegistrationDao {

    private final RegistrationRepository registrationRepository;
    public UserEntity save(UserEntity userEntity) {

        return registrationRepository.save(userEntity);
    }

    @Override
    public boolean isUserValid(AuthenticationRequest authenticationRequest) {

        System.out.println(authenticationRequest.getUsername());
        System.out.println(authenticationRequest.getPassword());

        List<UserEntity> userEntityList = registrationRepository.findByUsernameAndPassword(
                authenticationRequest.getUsername(), authenticationRequest.getPassword());

        System.out.println(userEntityList);

        return !userEntityList.isEmpty();
    }

    @Override
    public UserEntity saveToken(AuthenticationRequest authenticationRequest, String token) {
        UserEntity userEntity = registrationRepository.findByUsernameAndPassword(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()).get(0);

        if (userEntity == null) {
            throw new RuntimeException("User not found.");
        }

        userEntity.setAuthenticationToken(token);
        return registrationRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return registrationRepository.findAll();
    }
}
