package com.hema.ms.order.service;


import com.hema.ms.order.dto.OrderRequestDto;
import com.hema.ms.order.dto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto insert(OrderRequestDto orderRequestDto);
}
