package com.example.todo_list_app.repository;

import com.example.todo_list_app.domain.TodoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoListEntity, Long> {
    List<TodoListEntity> findByUserId(Long userId);
}
