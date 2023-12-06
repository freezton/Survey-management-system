package com.example.surveys.service.impl;

import com.example.surveys.entity.User;
import com.example.surveys.service.KafkaUserService;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserServiceImpl implements KafkaUserService {

    @Override
    public void handle(User user) {
        System.out.println(user);
    }
}
