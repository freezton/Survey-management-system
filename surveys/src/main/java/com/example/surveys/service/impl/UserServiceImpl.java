package com.example.surveys.service.impl;

import com.example.surveys.repository.UserRepository;
import com.example.surveys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean isUserExists(Long id) {
        return userRepository.findById(id).isPresent();
    }
}
