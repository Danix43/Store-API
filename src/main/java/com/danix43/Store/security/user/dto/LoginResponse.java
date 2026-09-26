package com.danix43.Store.security.user.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private Long expiresIn;
}
