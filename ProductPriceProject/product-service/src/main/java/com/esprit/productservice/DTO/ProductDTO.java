package com.esprit.productservice.DTO;


import com.esprit.priceservice.DTO.PriceDTO;

public record ProductDTO(String id, String name, String description, PriceDTO price) {

}