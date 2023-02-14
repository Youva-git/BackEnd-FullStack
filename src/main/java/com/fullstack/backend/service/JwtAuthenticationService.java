package com.fullstack.backend.service;

import com.fullstack.backend.dto.auth.AuthenticationRequest;
import com.fullstack.backend.dto.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface JwtAuthenticationService {
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);
}
