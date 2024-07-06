package authenticationSystem.service;

import authenticationSystem.request.AuthenticationRequest;
import authenticationSystem.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse createUser(AuthenticationRequest authenticationRequest);
}
