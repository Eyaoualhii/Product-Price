package com.esprit.priceservice.controllers;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.priceservice.entities.Price;
import com.esprit.priceservice.repository.PriceRepository;
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
    public PriceDTO getPriceByProductId(@PathVariable String productId) {
        Price price = priceRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Price not found"));
        return new PriceDTO(price.getId(), price.getAmount(), price.getCurrency(), price.getProductId());
    }
}
