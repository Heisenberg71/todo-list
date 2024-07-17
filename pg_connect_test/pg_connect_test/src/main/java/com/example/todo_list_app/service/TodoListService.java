package com.example.todo_list_app.service;

import com.example.todo_list_app.domain.TodoListEntity;
import com.example.todo_list_app.request.TodoListCreationRequest;
import com.example.todo_list_app.response.TodoListCreationResponse;
import com.example.todo_list_app.response.TodoListUpdateResponse;

import java.util.List;

public interface TodoListService {
    TodoListCreationResponse createTodoList(TodoListCreationRequest request);

    TodoListUpdateResponse updateTodoList(Long id, TodoListCreationRequest request);

    List<TodoListEntity> getTodoListsByUserId(Long userId);
}
