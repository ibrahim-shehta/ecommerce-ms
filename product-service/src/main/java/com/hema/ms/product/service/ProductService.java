package com.hema.ms.product.service;

import com.hema.ms.product.dto.ProductRequestDto;
import com.hema.ms.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto insert(ProductRequestDto productRequestDto);


    List<ProductResponseDto> getAllProducts();

    void deleteProductById(String id);
}
