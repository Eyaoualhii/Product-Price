package com.esprit.productservice.services;


import com.esprit.productservice.DTO.ProductDTO;
import org.springframework.data.domain.Page;

public interface IProductService {
    ProductDTO getProduct(String id);
}