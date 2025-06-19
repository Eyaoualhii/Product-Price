package com.esprit.priceservice.mapper;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.priceservice.entities.Price;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T21:38:51+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceDTO toDto(Price price) {
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

    @Override
    public Price toEntity(PriceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Price price = new Price();

        return price;
    }
}
