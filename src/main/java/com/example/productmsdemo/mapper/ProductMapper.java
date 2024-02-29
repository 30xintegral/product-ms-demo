package com.example.productmsdemo.mapper;

import com.example.productmsdemo.dto.request.ProductRequest;
import com.example.productmsdemo.dto.response.ProductResponse;
import com.example.productmsdemo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract ProductResponse mapEntityToDto(Product product);

    public abstract Product mapDtoToEntity(ProductResponse productResponse);

}
