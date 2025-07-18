package com.esprit.priceservice.controllers;


import com.esprit.DTO.PriceDTO;
import com.esprit.priceservice.entities.Price;
import com.esprit.priceservice.repository.PriceRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceRepository priceRepository;

    @GetMapping("/product/{productId}")
    @CircuitBreaker(name = "priceService", fallbackMethod = "fallbackGetPriceByProductId")
    public PriceDTO getPriceByProductId(@PathVariable String productId) {
        Price price = priceRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Price not found"));
        return new PriceDTO(price.getId(), price.getAmount(), price.getCurrency(), price.getProductId());
    }

    public PriceDTO fallbackGetPriceByProductId(String productId, Throwable throwable) {
        return new PriceDTO("0", 0.0, "USD", productId);
    }
}
