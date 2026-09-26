package com.danix43.Store.security.user.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
