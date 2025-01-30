package com.aoro.gimnasio.config.service;

import com.aoro.gimnasio.config.controller.request.AuthenticationRequest;
import com.aoro.gimnasio.config.controller.request.RegisterRequest;
import com.aoro.gimnasio.config.controller.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
