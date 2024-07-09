package com.example.todo_list_app.controller;

import com.example.todo_list_app.request.RegistrationRequest;
import com.example.todo_list_app.response.RegistrationResponse;
import com.example.todo_list_app.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    RegistrationResponse performRegistration(@RequestBody RegistrationRequest registrationRequest) {

        return registrationService.registerUser(registrationRequest);
    }
}
