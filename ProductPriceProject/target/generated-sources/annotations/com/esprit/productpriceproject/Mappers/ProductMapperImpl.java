package com.esprit.productpriceproject.Mappers;

import com.esprit.productpriceproject.DTO.PriceDTO;
import com.esprit.productpriceproject.DTO.ProductDTO;
import com.esprit.productpriceproject.Entities.Price;
import com.esprit.productpriceproject.Entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T21:28:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapToEntity(ProductDTO productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    @Override
    public ProductDTO mapToDto(Product product, Price price) {
        if ( product == null && price == null ) {
            return null;
        }

        PriceDTO price1 = null;
        price1 = priceToPriceDTO( price );

        Long id = null;
        String name = null;
        String description = null;

        ProductDTO productDTO = new ProductDTO( id, name, description, price1 );

        return productDTO;
    }

    protected PriceDTO priceToPriceDTO(Price price) {
        if ( price == null ) {
            return null;
        }

        String id = null;
        Double amount = null;
        String currency = null;
        String productId = null;

        PriceDTO priceDTO = new PriceDTO( id, amount, currency, productId );

        return priceDTO;
    }
}
