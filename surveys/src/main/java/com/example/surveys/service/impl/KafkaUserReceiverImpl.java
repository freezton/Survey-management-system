package com.example.surveys.service.impl;

import com.example.surveys.entity.User;
import com.example.surveys.service.KafkaUserReceiver;
import com.example.surveys.service.KafkaUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

@Service
@RequiredArgsConstructor
public class KafkaUserReceiverImpl implements KafkaUserReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final KafkaUserService kafkaUserService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder().create();
        receiver.receive()
                .subscribe(r -> {
                    User user = gson.fromJson(r.value().toString(), User.class);
                    kafkaUserService.handle(user);
                    r.receiverOffset().acknowledge();
                });
    }
}
