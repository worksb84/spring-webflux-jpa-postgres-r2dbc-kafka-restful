package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;

@Service
@Slf4j
public class KafkaReceiverService implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReactiveKafkaConsumerTemplate<String, Object> reactiveKafkaConsumerTemplate;
    // @Autowired
    // private KafkaReceiver<String, Object> kafkaReceiver;

    private Disposable consume() {

        // DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss:SSS z dd
        // MMM yyyy");
        // kafkaReceiver.receive().subscribe(record -> {
        // ReceiverOffset offset = record.receiverOffset();
        // Instant timestamp = Instant.ofEpochMilli(record.timestamp());
        // System.out.printf("Received message: topic-partition=%s offset=%d
        // timestamp=%s key=%d value=%s\n",
        // offset.topicPartition(),
        // offset.offset(),
        // dateFormat.format(timestamp),
        // record.key(),
        // record.value());
        // offset.acknowledge();
        // });
        return reactiveKafkaConsumerTemplate
                .receiveAutoAck()
                .doOnNext(r -> {
                    User user = (User) r.value();
                    log.info("user1: {} {}", user.getNickname(), user.getEmail());
                    userRepository.save(user).subscribe(savedUser -> {
                        System.out.println("insert success! " + savedUser.getId());
                    }, error -> {
                        System.err.println("insert fail! " + error.getMessage());
                    });
                })
                .doOnError(e -> {
                    System.out.println("error: " + e);
                }).subscribe();
    }

    @Override
    public void run(String... args) throws Exception {
        consume();
    }
}
