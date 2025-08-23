package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserQueryService {
    Mono<User> get(Long id);

    UserDetails auth(User user);

    Flux<User> all();
}
