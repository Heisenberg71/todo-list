package authenticationSystem.service;

import authenticationSystem.dao.AuthenticationDao;
import authenticationSystem.domain.UserEntity;
import authenticationSystem.request.AuthenticationRequest;
import authenticationSystem.response.AuthenticationResponse;

public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationDao authenticationDao;

    public AuthenticationServiceImpl(AuthenticationDao authenticationDao) {
        this.authenticationDao = authenticationDao;
    }

    public AuthenticationResponse createUser(AuthenticationRequest authenticationRequest) {

        if (!authenticationRequest.getPassword().equals(authenticationRequest.getConfirmPassword())) {
            //TODO: Throw exception
        }

        UserEntity userEntity = generateUserEntity(authenticationRequest);

        authenticationDao.createUser(userEntity);

        return AuthenticationResponse.builder()
                .userCreationMessage("Hello, " + userEntity.getUsername() + "! " + "Your account is created")
                .build();
    }

    private String generateAuthenticationToken(AuthenticationRequest authenticationRequest) {
        return null;
    }

    private UserEntity generateUserEntity(AuthenticationRequest authenticationRequest) {

        return UserEntity.builder()
                .username(authenticationRequest.getUsername())
                .email(authenticationRequest.getEmail())
                .password(authenticationRequest.getPassword())
                .build();
    }
}
