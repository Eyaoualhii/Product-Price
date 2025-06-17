package com.esprit.priceservice.services;

import com.esprit.priceservice.DTO.PriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "price-service")
public interface PriceClient {
    @GetMapping("/prices/product/{productId}")
    PriceDTO getPriceByProductId(@PathVariable String productId);
}
