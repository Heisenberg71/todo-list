package com.example.todo_list_app.service;


import com.example.todo_list_app.request.RegistrationRequest;
import com.example.todo_list_app.response.RegistrationResponse;

public interface RegistrationService {

    public RegistrationResponse registerUser(RegistrationRequest registrationRequest);
}
