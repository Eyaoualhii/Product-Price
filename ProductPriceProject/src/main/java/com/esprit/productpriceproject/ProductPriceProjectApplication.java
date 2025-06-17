package com.esprit.productpriceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProductPriceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductPriceProjectApplication.class, args);
    }

}
