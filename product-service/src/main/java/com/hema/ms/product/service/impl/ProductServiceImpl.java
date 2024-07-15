package com.hema.ms.product.service.impl;

import com.hema.ms.product.dto.ProductRequestDto;
import com.hema.ms.product.dto.ProductResponseDto;
import com.hema.ms.product.mapper.ProductMapper;
import com.hema.ms.product.model.Product;
import com.hema.ms.product.repository.ProductRepository;
import com.hema.ms.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto insert(ProductRequestDto productRequestDto) {

        Product product = productMapper.map(productRequestDto);

        product = productRepository.save(product);
        ProductResponseDto productResponseDto = productMapper.unMap(product);
        log.info("product saved successfully !!");
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = productMapper.unMap(products);
        return productResponseDtos;
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
