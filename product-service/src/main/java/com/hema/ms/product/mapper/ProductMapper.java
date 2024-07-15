package com.hema.ms.product.mapper;

import com.hema.ms.product.dto.ProductRequestDto;
import com.hema.ms.product.dto.ProductResponseDto;
import com.hema.ms.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
    public interface ProductMapper {

    Product map(ProductRequestDto product);
    ProductResponseDto unMap(Product product);
    List<ProductResponseDto> unMap(List<Product> product);
}
