package com.example.surveys.service;

import com.example.surveys.entity.User;

public interface KafkaUserService {

    void handle(User user);

}
