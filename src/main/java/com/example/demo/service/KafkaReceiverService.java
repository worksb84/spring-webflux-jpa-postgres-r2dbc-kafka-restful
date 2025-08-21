package com.example.demo.service;

import java.text.DateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOffset;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaReceiverService implements CommandLineRunner {

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
