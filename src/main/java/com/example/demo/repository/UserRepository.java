package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.domain.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
