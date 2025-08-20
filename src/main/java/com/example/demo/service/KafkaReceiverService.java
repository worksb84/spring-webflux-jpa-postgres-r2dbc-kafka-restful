package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaReceiverService implements ApplicationRunner {
    @Autowired
    private ReactiveKafkaConsumerTemplate<String, Object> reactiveKafkaConsumerTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.reactiveKafkaConsumerTemplate
                .receiveAutoAck()
                .doOnNext(r -> {
                    User user = (User) r.value();
                    log.info("user: {} {}", user.getId(), user.getNickname());
                })
                .doOnError(e -> {
                    System.out.println("error: " + e);
                })
                .subscribe();
    }
}
