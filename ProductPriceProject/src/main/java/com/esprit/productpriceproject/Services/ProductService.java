package com.esprit.productpriceproject.Services;

import com.esprit.productpriceproject.DTO.ProductDTO;
import com.esprit.productpriceproject.Entities.Price;
import com.esprit.productpriceproject.Entities.Product;
import com.esprit.productpriceproject.Mappers.ProductMapper;
import com.esprit.productpriceproject.Repository.Mongo.PriceRepository;
import com.esprit.productpriceproject.Repository.JPA.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,
                          PriceRepository priceRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO add(ProductDTO productDto) {
        Price price = new Price();
        price.setAmount(productDto.amount());
        price.setCurrency(productDto.currency());

        Price savedPrice = priceRepository.save(price);

        Product product = productMapper.mapToEntity(productDto);
        product.setPriceId(savedPrice.getId());
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct, savedPrice);
    }



    @Override
    public boolean delete(String idProduct) {
        productRepository.deleteById(Long.valueOf(idProduct));
        return productRepository.existsById(Long.valueOf(idProduct));
    }
    @Override
    public Page<ProductDTO> getProducts(int pageNbr, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNbr, pageSize))
                .map(product -> {
                    Price price = priceRepository.findById(Long.valueOf(product.getPriceId()))
                            .orElse(null);
                    return productMapper.mapToDto(product, price);
                });
    }

    @Override
    public ProductDTO getProduct(String id) {
        Product product = productRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("product not found"));
        Price price = priceRepository.findById(Long.valueOf(product.getPriceId()))
                .orElse(null);
        return productMapper.mapToDto(product, price);
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product product = productRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("product not found with this name"));
        Price price = priceRepository.findById(Long.valueOf(product.getPriceId()))
                .orElse(null);
        return productMapper.mapToDto(product, price);
    }

}
