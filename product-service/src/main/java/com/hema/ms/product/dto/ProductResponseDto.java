package com.hema.ms.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto implements Serializable {

    private static final long serialVersionUID = 955332705318486542L;

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
