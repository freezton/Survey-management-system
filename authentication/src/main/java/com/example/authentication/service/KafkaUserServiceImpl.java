package com.example.authentication.service;

import com.example.authentication.dto.UserDto;
import com.example.authentication.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaUserServiceImpl implements KafkaUserService{

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(UserDto dto) {
        String topic = "users-topic";
        sender.send(
                Mono.just(
                        SenderRecord.create(
                                topic,
                                0,
                                System.currentTimeMillis(),
                                String.valueOf(dto.hashCode()),
                                dto,
                                null
                        )
                )
        ).subscribe();
    }
}
