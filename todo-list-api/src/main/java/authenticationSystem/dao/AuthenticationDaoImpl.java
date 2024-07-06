package authenticationSystem.dao;

import authenticationSystem.repository.AuthenticationRepository;
import authenticationSystem.domain.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationDaoImpl implements AuthenticationDao {

    private final AuthenticationRepository authenticationRepository;

    public AuthenticationDaoImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return authenticationRepository.save(userEntity);
    }
}
