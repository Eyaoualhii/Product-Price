package com.esprit.productservice.mapper;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.productservice.DTO.ProductDTO;
import com.esprit.productservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Mapping Product + PriceDTO to ProductDTO
    @Mapping(target = "price", source = "priceDTO")
    ProductDTO toDto(Product product, PriceDTO priceDTO);

    // Mapping ProductDTO to Product (you'll need priceId separately)
    Product toEntity(ProductDTO productDTO);
}