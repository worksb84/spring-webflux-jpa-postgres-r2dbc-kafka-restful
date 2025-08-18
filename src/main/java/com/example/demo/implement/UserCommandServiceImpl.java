package com.example.demo.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.annotation.ErrorLog;
import com.example.demo.domain.User;
import com.example.demo.exception.BaseException;
import com.example.demo.helper.ErrorCode;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserCommandService;

import reactor.core.publisher.Mono;

// @Log4j2
@Service
public class UserCommandServiceImpl implements UserCommandService {

    // private final Logger logger =
    // LogManager.getLogger(UserCommandServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @ErrorLog
    @Override
    public Mono<Void> create(User user) {
        return userRepository.save(user).then();
    }

    @Override
    public Mono<Void> update(User user) {
        return userRepository.findById(user.getId())
                .flatMap(entity -> {
                    entity.setNickname(user.getNickname());
                    return userRepository.save(entity).then();
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id).then();
    }

}
