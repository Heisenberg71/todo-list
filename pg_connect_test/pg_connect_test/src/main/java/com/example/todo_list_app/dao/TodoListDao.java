package com.example.todo_list_app.dao;

import com.example.todo_list_app.domain.TodoListEntity;

import java.util.List;

public interface TodoListDao {
    TodoListEntity findById(Long id);
    TodoListEntity save(TodoListEntity todoListEntity);
    List<TodoListEntity> findByUserId(Long userId);
}
