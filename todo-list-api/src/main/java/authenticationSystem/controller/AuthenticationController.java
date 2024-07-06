package authenticationSystem.controller;

import authenticationSystem.request.AuthenticationRequest;
import authenticationSystem.response.AuthenticationResponse;
import authenticationSystem.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/users")
    public AuthenticationResponse createUser(@RequestBody AuthenticationRequest authenticationRequest) {

        System.out.println("hello");

        return authenticationService.createUser(authenticationRequest);
    }
}
