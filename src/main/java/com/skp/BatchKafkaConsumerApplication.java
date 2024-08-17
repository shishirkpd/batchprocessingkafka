package com.skp;

import com.skp.service.BatchKafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchKafkaConsumerApplication {

    @Autowired
    private BatchKafkaConsumerService kafkaConsumerService;

    public static void main(String[] args) {
        SpringApplication.run(BatchKafkaConsumerApplication.class, args);
    }
}
