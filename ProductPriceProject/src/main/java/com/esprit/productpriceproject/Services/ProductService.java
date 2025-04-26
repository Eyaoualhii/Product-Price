package com.esprit.productpriceproject.Services;

import com.esprit.productpriceproject.DTO.ProductDTO;
import com.esprit.productpriceproject.Entities.Product;
import com.esprit.productpriceproject.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;
    public String getProducts() {
        return productRepository.findAll().toString();
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDTO(product.getName(), product.getDescription(), product.getPriceId());
    }
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPriceId(productDTO.priceId());
        productRepository.save(product);
        return new ProductDTO(product.getName(), product.getDescription(), product.getPriceId());
    }
}
