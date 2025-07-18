package com.esprit.productservice.services;


import com.esprit.DTO.ProductDTO;

public interface IProductService {
    ProductDTO getProduct(String id);
}