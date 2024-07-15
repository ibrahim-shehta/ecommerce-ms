package com.hema.ms.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequestDto implements Serializable {
    private String name;
    private String description;
    private BigDecimal price;
}
