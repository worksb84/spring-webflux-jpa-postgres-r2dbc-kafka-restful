package com.example.demo.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.annotation.ErrorLog;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserCommandService;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

@Log4j2
@Service
public class UserCommandServiceImpl implements UserCommandService {

    // private final Logger logger =
    // LogManager.getLogger(UserCommandServiceImpl.class);
    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private ReactiveKafkaProducerTemplate<String, Object> reactiveKafkaProducerTemplate;

    @ErrorLog
    @Override
    public Mono<SenderResult<Void>> create(User user) {
        return reactiveKafkaProducerTemplate.send("user-topic", user);
    }

    @Override
    public Mono<Void> update(User user) {
        return Mono.just(null);
        // return userRepository.findById(user.getId())
        //         .flatMap(entity -> {
        //             entity.setNickname(user.getNickname());
        //             return userRepository.save(entity).then();
        //         });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return Mono.just(null);
        // return userRepository.deleteById(id).then();
    }

}
