package authenticationSystem.dao;

import authenticationSystem.domain.UserEntity;

public interface AuthenticationDao {

    UserEntity createUser(UserEntity userEntity);
}
