package com.hema.ms.order.controller;

import com.hema.ms.order.dto.OrderRequestDto;
import com.hema.ms.order.dto.OrderResponseDto;
import com.hema.ms.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto insert(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto insert = orderService.insert(orderRequestDto);
        return insert;
    }


}
