package com.esprit.priceservice.repository;


import com.esprit.priceservice.entities.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PriceRepository extends MongoRepository<Price, Long> {
    Optional<Price> findByProductId(String productId);
}
