package com.example.productmsdemo.service;

import com.example.productmsdemo.dto.request.ProductRequest;
import com.example.productmsdemo.dto.response.ProductResponse;
import com.example.productmsdemo.entity.Product;

import java.util.List;

public interface ProductService {
    void create(ProductRequest productRequest);

    ProductResponse getById(Long id);

    List<ProductResponse> getAll();

    void decreaseCountBy(long id,int count);

    void update(Long id,ProductRequest productRequest);
}
