package com.skp.controller;

import com.skp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/produce")
    public String produceMessages(@RequestParam int batchSize) {
        kafkaProducerService.sendBatchMessages(batchSize);
        return "Produced " + batchSize + " messages.";
    }
}
