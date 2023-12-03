package com.example.authentication.dto;

import lombok.Data;

@Data
public class SingUpRequest {
    String username;
    String email;
    String password;
}
