package com.example.productmsdemo.service;

import com.example.productmsdemo.dto.request.ProductRequest;
import com.example.productmsdemo.dto.response.ProductResponse;
import com.example.productmsdemo.entity.Product;
import com.example.productmsdemo.mapper.ProductMapper;
import com.example.productmsdemo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void create(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCount(productRequest.getCount());
        productRepository.save(product);
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No such product found by id=" + id));
        return ProductMapper.INSTANCE.mapEntityToDto(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Product product :
                products) {
            ProductResponse productResponse = ProductMapper.INSTANCE.mapEntityToDto(product);
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }

    @Override
    @Transactional
    public void decreaseCountBy(long id,int count) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No such product"));
        if (product.getCount()<count){
            throw new RuntimeException("Not enough stock");
        }
        productRepository.decreaseCountById(id, count);
    }

    @Override
    @Transactional
    public void update(Long id,ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No such product"));
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        if (productRequest.getCount()<0){
            throw new RuntimeException("Invalid count");
        }
        product.setCount(productRequest.getCount());
        productRepository.save(product);
    }
}
