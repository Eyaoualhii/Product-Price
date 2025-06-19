package com.esprit.priceservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventConsumer {

        @KafkaListener(topics = "product-topic", groupId = "group_id")
        public void consume(String message) {
            System.out.println("Received product event: " + message);
        }


}
