package com.example.authentication.service;

import com.example.authentication.dto.UserDto;
import com.example.authentication.entity.User;

public interface KafkaUserService {

    void send(UserDto dto);
}
