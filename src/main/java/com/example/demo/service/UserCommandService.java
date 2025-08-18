package com.example.demo.service;

import com.example.demo.domain.User;

import reactor.core.publisher.Mono;

public interface UserCommandService {
    Mono<Void> create(User user);

    Mono<Void> update(User user);

    Mono<Void> delete(Long id);
}
