package com.esprit.productservice.kafka;

import com.esprit.DTO.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, ProductEvent> kafkaProductEventTemplate;
    private final ObjectMapper objectMapper;

    public void sendProductCreatedEvent(ProductDTO productDTO) {
        try {
            String message = objectMapper.writeValueAsString(productDTO);
            kafkaTemplate.send("product-topic", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing product", e);
        }
    }
    // with object
    public void sendProductCreatedEventAsObject(ProductEvent productEvent) {
        kafkaProductEventTemplate.send("product-topic", productEvent);
    }
}

