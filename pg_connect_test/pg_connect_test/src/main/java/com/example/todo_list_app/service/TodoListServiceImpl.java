package com.example.todo_list_app.service;

import com.example.todo_list_app.dao.TodoListDao;
import com.example.todo_list_app.domain.TodoListEntity;
import com.example.todo_list_app.request.TodoListCreationRequest;
import com.example.todo_list_app.response.TodoListCreationResponse;
import com.example.todo_list_app.response.TodoListUpdateResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListDao todoListDao;

    @Override
    public TodoListCreationResponse createTodoList(TodoListCreationRequest request) {

        TodoListEntity todoListEntity = TodoListEntity.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .description(request.getDescription())
                .taskStatus(request.getTaskStatus())
                .build();

        todoListDao.save(todoListEntity);

        return TodoListCreationResponse.builder()
                .message("Todo list created successfully")
                .build();
    }

    @Override
    public TodoListUpdateResponse updateTodoList(Long id, TodoListCreationRequest request) {

        TodoListEntity todoListEntity = todoListDao.findById(id);

        if (request.getTitle() != null) todoListEntity.setTitle(request.getTitle());
        if (request.getDescription() != null) todoListEntity.setDescription(request.getDescription());
        if (request.getTaskStatus() != null) todoListEntity.setTaskStatus(request.getTaskStatus());

        todoListDao.save(todoListEntity);

        return TodoListUpdateResponse.builder()
                .message("Todo list updated successfully")
                .build();
    }

    @Override
    public List<TodoListEntity> getTodoListsByUserId(Long userId) {

        return todoListDao.findByUserId(userId);
    }
}
