package com.hema.ms.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderRequestDto {

    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
