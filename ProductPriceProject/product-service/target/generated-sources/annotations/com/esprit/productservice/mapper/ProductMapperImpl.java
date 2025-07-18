package com.esprit.productservice.mapper;

import com.esprit.DTO.PriceDTO;
import com.esprit.DTO.ProductDTO;
import com.esprit.productservice.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-18T15:03:46+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product, PriceDTO priceDTO) {
        if ( product == null && priceDTO == null ) {
            return null;
        }

        String id = null;
        if ( priceDTO != null ) {
            id = priceDTO.id();
        }

        String name = null;
        String description = null;
        PriceDTO price = null;

        ProductDTO productDTO = new ProductDTO( id, name, description, price );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }
}
