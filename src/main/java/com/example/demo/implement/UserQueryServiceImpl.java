package com.example.demo.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Mono<User> get(Long id) {
        Mono<User> user = userRepository.findById(id);
        user.subscribe(
                data -> System.out.println(data),
                error -> System.err.println(error),
                () -> System.out.println("Completed"));

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<User> all() {
        Flux<User> users = userRepository.findAll();
        users.subscribe(
                data -> System.out.println(data),
                error -> System.err.println(error),
                () -> System.out.println("Completed"));

        return users;
    }

}
