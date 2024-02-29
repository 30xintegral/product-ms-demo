package com.example.productmsdemo.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private int count;
    private double price;
}
