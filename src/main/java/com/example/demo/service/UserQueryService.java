package com.example.demo.service;

import com.example.demo.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserQueryService {
    Mono<User> get(Long id);

    Flux<User> all();
}
