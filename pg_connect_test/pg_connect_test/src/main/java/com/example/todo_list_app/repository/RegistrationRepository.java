package com.example.todo_list_app.repository;

import com.example.todo_list_app.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<UserEntity, Long> {
}
