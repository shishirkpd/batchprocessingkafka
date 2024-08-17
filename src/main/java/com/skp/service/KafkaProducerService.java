package com.skp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC_NAME = "batch-processing";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.printf("Sent message: %s%n", message);
    }

    public void sendBatchMessages(int batchSize) {
        for (int i = 1; i <= batchSize; i++) {
            String message = "Message " + i;
            sendMessage(message);
        }
    }
}
