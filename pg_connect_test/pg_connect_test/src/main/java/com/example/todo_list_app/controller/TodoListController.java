package com.example.todo_list_app.controller;

import com.example.todo_list_app.domain.TodoListEntity;
import com.example.todo_list_app.request.TodoListCreationRequest;
import com.example.todo_list_app.response.TodoListCreationResponse;
import com.example.todo_list_app.response.TodoListUpdateResponse;
import com.example.todo_list_app.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo-list")
public class TodoListController {

    private final TodoListService todoListService;

    @PostMapping("/create")
    TodoListCreationResponse createTodoList(@RequestBody TodoListCreationRequest request) {

        return todoListService.createTodoList(request);
    }

    @PutMapping("/{id}")
    TodoListUpdateResponse updateTodoList(@PathVariable Long id, @RequestBody TodoListCreationRequest request) {

        return todoListService.updateTodoList(id, request);
    }

    @GetMapping("/{id}")
    List<TodoListEntity> getTodoListsByUserId(@PathVariable Long id) {

        return todoListService.getTodoListsByUserId(id);
    }
}
