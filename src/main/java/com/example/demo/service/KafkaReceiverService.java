package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;

@Service
@Slf4j
public class KafkaReceiverService implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public KafkaReceiverService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private ReactiveKafkaConsumerTemplate<String, Object> reactiveKafkaConsumerTemplate;
    @Autowired
    private KafkaReceiver<String, Object> kafkaReceiver;

    private Flux<ConsumerRecord<String, Object>> consume() {

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
                    log.info("user: {} {} {}", user.getId(), user.getNickname(), user.getEmail());
                    userRepository.save(user);
                })
                .doOnError(e -> {
                    System.out.println("error: " + e);
                });
    }

    @Override
    public void run(String... args) throws Exception {
        consume().subscribe();
    }
}
