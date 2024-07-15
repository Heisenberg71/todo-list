package com.example.todo_list_app.controller;

import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.request.AuthenticationRequest;
import com.example.todo_list_app.response.AuthenticationTokenResponse;
import com.example.todo_list_app.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    AuthenticationTokenResponse performLogin(@RequestBody AuthenticationRequest authenticationRequest) {

        return loginService.authenticateUser(authenticationRequest);
    }

    @GetMapping("/all")
    List<UserEntity> getAllUsers() {
        return loginService.getAllUsers();
    }
}
