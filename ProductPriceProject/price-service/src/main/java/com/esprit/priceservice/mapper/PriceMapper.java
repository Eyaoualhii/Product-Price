package com.esprit.priceservice.mapper;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.priceservice.entities.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceDTO toDto(Price price);
    Price toEntity(PriceDTO dto);
}