package com.esprit.priceservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
//import com.esprit.ProductEvent;
@Component
public class ProductEventConsumer {

    @KafkaListener(topics = "product-topic", groupId = "group_id")
    public void consume(String message) {
            System.out.println("Received product event: " + message);
    }

//    @KafkaListener(
//            topics = "product-topic",
//            groupId = "group_id",
//            containerFactory = "productEventKafkaListenerContainerFactory"
//    )
//    public void consumeProductEvent(ProductEvent productEvent) {
//        System.out.println("Received product event as object: " + productEvent);
//    }
}
