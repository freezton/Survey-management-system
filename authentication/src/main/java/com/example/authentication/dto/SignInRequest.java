package com.example.authentication.dto;

import lombok.Data;

@Data
public class SignInRequest {
    String username;
    String password;
}
