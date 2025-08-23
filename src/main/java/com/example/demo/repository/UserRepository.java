package com.example.demo.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.domain.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    Mono<User> findByEmailAndPassword(String email, String password);
    
    @Query("SELECT * FROM users WHERE nickname = :nickname")
    Mono<User> findByNickname(String nickname);
}
