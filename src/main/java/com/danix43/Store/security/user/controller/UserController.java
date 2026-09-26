package com.danix43.Store.security.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danix43.Store.security.user.dto.RegisterRequest;
import com.danix43.Store.security.user.dto.LoginRequest;
import com.danix43.Store.security.user.dto.LoginResponse;
import com.danix43.Store.security.user.model.User;
import com.danix43.Store.security.user.service.JwtService;
import com.danix43.Store.security.user.service.UserAuthentificationService;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final JwtService jwtService;

    private final UserAuthentificationService authentificationService;

    public UserController(JwtService jwtService, UserAuthentificationService userAuthentificationService) {
        this.jwtService = jwtService;
        this.authentificationService = userAuthentificationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> postRegisterNewUser(@RequestBody RegisterRequest entity) {
        User registeredUser = authentificationService.registerUser(entity);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getLoginToken(@RequestBody LoginRequest entity) {
        User authUser = authentificationService.authenticate(entity);

        String jwtToken = jwtService.generateToken(authUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
