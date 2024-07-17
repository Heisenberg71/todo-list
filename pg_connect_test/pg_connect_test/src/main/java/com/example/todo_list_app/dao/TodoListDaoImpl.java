package com.example.todo_list_app.dao;

import com.example.todo_list_app.domain.TodoListEntity;
import com.example.todo_list_app.repository.TodoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TodoListDaoImpl implements TodoListDao {

    private final TodoListRepository todoListRepository;

    @Override
    public TodoListEntity findById(Long id) {
        return todoListRepository.findById(id).orElse(null);
    }

    @Override
    public TodoListEntity save(TodoListEntity todoListEntity) {
        return todoListRepository.save(todoListEntity);
    }

    @Override
    public List<TodoListEntity> findByUserId(Long userId) {
        return todoListRepository.findByUserId(userId);
    }
}
