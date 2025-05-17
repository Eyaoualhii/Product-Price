package com.esprit.productpriceproject.Services;

import com.esprit.productpriceproject.DTO.ProductDTO;
import com.esprit.productpriceproject.Entities.Product;
import com.esprit.productpriceproject.Mappers.ProductMapper;
import com.esprit.productpriceproject.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    ProductRepository productRepository;
    private final ProductMapper productMapper;



    @Override
    public ProductDTO add(ProductDTO productDto) {
        Product product = productMapper.mapToEntity(productDto);
        product.setDescription("New product added");
        product.setName("name of product");
        return productMapper.mapToDto(productRepository.save(product));
    }

    @Override
    public boolean delete(String idProduct) {
        productRepository.deleteById(Long.valueOf(idProduct));
        return productRepository.existsById(Long.valueOf(idProduct));
    }

    @Override
    public Page<ProductDTO> getProducts(int pageNbr, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNbr,pageSize))
                .map(productMapper::mapToDto);
    }

    @Override
    public ProductDTO getProduct(String id) {
        return productRepository.findById(Long.valueOf(id))
                .map(productMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("product not found"));
    }

    @Override
    public ProductDTO getProductByName(String name) {
        return productRepository.findByName(name)
                .map(productMapper::mapToDto)
                .orElseThrow(() ->new IllegalArgumentException("product not found with this name"));
    }
}
