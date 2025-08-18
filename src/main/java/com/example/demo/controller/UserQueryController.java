package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserQueryService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserQueryController {
    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/get")
    public Mono<User> get(Long id) {
        return userQueryService.get(id);
    }

    @GetMapping("/all")
    public Flux<User> all() {
        return userQueryService.all();
    }
}
