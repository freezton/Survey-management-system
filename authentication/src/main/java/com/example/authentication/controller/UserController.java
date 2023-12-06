package com.example.authentication.controller;

import com.example.authentication.dto.UserDto;
import com.example.authentication.entity.User;
import com.example.authentication.mapper.UserMapper;
import com.example.authentication.service.KafkaUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final KafkaUserService kafkaUserService;

    @PostMapping("/send")
    public void send(@RequestBody User user) {
        UserDto dto = userMapper.toDto(user);
        kafkaUserService.send(dto);
    }
}
