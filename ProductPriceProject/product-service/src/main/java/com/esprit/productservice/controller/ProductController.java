package com.esprit.productservice.controller;


import com.esprit.DTO.ProductDTO;
import com.esprit.productservice.kafka.ProductProducer;
import com.esprit.productservice.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final ProductProducer productProducer;
//    @PostMapping
//    public ProductDTO add(@RequestBody ProductDTO productDto) {
//        return productService.add(productDto);
//    }
//
//
//
//    @DeleteMapping("{id}")
//    public boolean delete( @PathVariable String id){
//        return productService.delete(id);
//    }


//    @GetMapping
//    public Page<ProductDTO> getProducts(int pageNbr, int pageSize){
//        return productService.getProducts(pageNbr,pageSize);
//    }

    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }
//
//    @GetMapping("name/{name}")
//    public ProductDTO getProductByName(@PathVariable String name){
//        return productService.getProductByName(name);
//    }

    @PostMapping("/send")
    public ResponseEntity<String> sendProduct(@RequestBody ProductDTO productDTO) {
        productProducer.sendProductCreatedEvent(productDTO);
        return ResponseEntity.ok("Product sent to Kafka");
    }
}
