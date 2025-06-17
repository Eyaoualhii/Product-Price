package com.esprit.productservice.services;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.priceservice.services.PriceClient;
import com.esprit.productservice.DTO.ProductDTO;
import com.esprit.productservice.entities.Product;
import com.esprit.productservice.mapper.ProductMapper;
import com.esprit.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final PriceClient priceClient;
    private final ProductMapper productMapper;


    @Override
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        PriceDTO priceDTO = priceClient.getPriceByProductId(product.getPriceId());

        return productMapper.toDto(product, priceDTO);
    }
}