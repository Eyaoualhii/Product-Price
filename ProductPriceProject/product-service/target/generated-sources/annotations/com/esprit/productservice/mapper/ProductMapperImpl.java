package com.esprit.productservice.mapper;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.productservice.DTO.ProductDTO;
import com.esprit.productservice.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T21:48:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product, PriceDTO priceDTO) {
        if ( product == null && priceDTO == null ) {
            return null;
        }

        PriceDTO price = null;
        Long id = null;
        if ( priceDTO != null ) {
            price = priceDTO;
            if ( priceDTO.id() != null ) {
                id = Long.parseLong( priceDTO.id() );
            }
        }

        String name = null;
        String description = null;

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
