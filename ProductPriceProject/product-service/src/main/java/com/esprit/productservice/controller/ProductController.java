package com.esprit.productservice.controller;


import com.esprit.productservice.DTO.ProductDTO;
import com.esprit.productservice.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
//
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
        return productService.getProduct(Long.valueOf(id));
    }
//
//    @GetMapping("name/{name}")
//    public ProductDTO getProductByName(@PathVariable String name){
//        return productService.getProductByName(name);
//    }
}
