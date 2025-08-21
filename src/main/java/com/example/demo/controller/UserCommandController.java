package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.ErrorLog;
import com.example.demo.domain.User;
import com.example.demo.service.UserCommandService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserCommandController {
    @Autowired
    private UserCommandService userCommandService;

    @ErrorLog
    @PostMapping("/create")
    @ResponseBody
    public Mono<SenderResult<Void>> create(@RequestBody User user) {
          return userCommandService.create(user);
    }

    @ErrorLog
    @PutMapping("/update")
    @ResponseBody
    public Mono<Void> update(@RequestBody User user) {
        return userCommandService.update(user);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Mono<Void> delete(Long id) {
        return userCommandService.delete(id);
    }
}
