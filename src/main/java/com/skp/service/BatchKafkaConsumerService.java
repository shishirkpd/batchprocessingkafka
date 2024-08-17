package com.skp.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class BatchKafkaConsumerService {

    private static final int POLL_TIMEOUT_MS = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    @Autowired
    private KafkaConsumer<String, String> kafkaConsumer;

    @PostConstruct
    public void startKafkaConsumer() {
        kafkaConsumer.subscribe(Collections.singletonList("batch-processing"));

        // Start the polling in a separate thread to prevent blocking the main thread
        executor.submit(() -> {
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(POLL_TIMEOUT_MS));
                processBatch(records);
            }
        });
    }

    private void processBatch(ConsumerRecords<String, String> records) {
        long start = System.currentTimeMillis();
        for (ConsumerRecord<String, String> record : records) {
            // Processing logic for each record
            System.out.printf("Processing record: %s%n", record.value());
        }
        // Commit offsets after processing the batch
        kafkaConsumer.commitAsync();
    }
}
