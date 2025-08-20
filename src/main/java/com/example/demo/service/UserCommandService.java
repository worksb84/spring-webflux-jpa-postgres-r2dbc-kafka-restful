package com.example.demo.service;

import com.example.demo.domain.User;

import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

public interface UserCommandService {
    Mono<SenderResult<Void>> create(User user);

    Mono<Void> update(User user);

    Mono<Void> delete(Long id);
}
