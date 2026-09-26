package com.danix43.Store.security.user.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danix43.Store.security.user.dto.LoginRequest;
import com.danix43.Store.security.user.dto.RegisterRequest;
import com.danix43.Store.security.user.model.User;
import com.danix43.Store.security.user.repository.UserRepository;

@Service
public class UserAuthentificationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public UserAuthentificationService(UserRepository userRepo, AuthenticationManager authMan,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepo;
        this.authenticationManager = authMan;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        return userRepository.findByEmail(request.getEmail()).orElseThrow();
    }

}
