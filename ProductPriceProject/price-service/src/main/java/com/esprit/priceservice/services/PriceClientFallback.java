package com.esprit.priceservice.services;


import com.esprit.DTO.PriceDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceClientFallback implements PriceClient {
    @Override
    public PriceDTO getPriceByProductId(String productId) {
        return new PriceDTO("0", 0.0, "N/A", productId);
    }
}
