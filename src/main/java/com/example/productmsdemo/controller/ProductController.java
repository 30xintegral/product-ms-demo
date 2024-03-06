package com.example.productmsdemo.controller;

import com.example.productmsdemo.dto.request.ProductRequest;
import com.example.productmsdemo.dto.response.ProductResponse;
import com.example.productmsdemo.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public void create(@RequestBody ProductRequest productRequest){
        log.info("create api called");
        productService.create(productRequest);
        log.info("succeeded");
    }

    @GetMapping("/getProdById/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        log.info("getProductById api called");
        return productService.getById(id);
    }

    @GetMapping("/getAllProds")
    public List<ProductResponse> getAll(){
        return productService.getAll();
    }

    @PatchMapping("/decreaseCount/{id}/{count}")
    public void decreaseCountBy(@PathVariable Long id, @PathVariable int count){
        productService.decreaseCountBy(id, count);
    }

    @PutMapping("/updateProduct/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        productService.update(id, productRequest);
    }

    @PatchMapping("/increaseCount/{id}/{count}")
    public void increaseCountBy(@PathVariable Long id, @PathVariable int count){
        productService.increaseCountBy(id, count);
    }
}
