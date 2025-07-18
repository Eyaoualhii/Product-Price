package com.esprit.productservice.mapper;

import com.esprit.DTO.PriceDTO;
import com.esprit.DTO.ProductDTO;
import com.esprit.productservice.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductDTO toDto(Product product, PriceDTO priceDTO);

    Product toEntity(ProductDTO productDTO);
}