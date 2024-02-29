package com.example.productmsdemo.dto.response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;

    private String name;
    private int count;
    private double price;
}
