package com.esprit.productservice.services;

import com.esprit.priceservice.DTO.PriceDTO;
import com.esprit.priceservice.services.PriceClient;
import com.esprit.productservice.DTO.ProductDTO;
import com.esprit.productservice.entities.Product;
import com.esprit.productservice.mapper.ProductMapper;
import com.esprit.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final PriceClient priceClient;
    private final ProductMapper productMapper;


    @Override
    public ProductDTO getProduct(String id) {
        System.out.println(id);
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        Product product = productOptional.get();
        System.out.println("Found product: ");
        PriceDTO priceDTO = priceClient.getPriceByProductId(product.getPriceId());

        return productMapper.toDto(product, priceDTO);
    }
}