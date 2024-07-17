package com.example.todo_list_app.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoListCreationRequest {

    private Long userId;
    private String title;
    private String description;
    private String taskStatus;
}
