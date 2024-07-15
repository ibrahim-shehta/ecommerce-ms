package com.hema.ms.order.service.impl;

import com.hema.ms.order.client.InventoryClient;
import com.hema.ms.order.dto.OrderRequestDto;
import com.hema.ms.order.dto.OrderResponseDto;
import com.hema.ms.order.mapper.OrderMapper;
import com.hema.ms.order.model.Order;
import com.hema.ms.order.repository.OrderRepository;
import com.hema.ms.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;

    @Override
    public OrderResponseDto insert(OrderRequestDto orderRequestDto) {
        boolean inStock = inventoryClient.isInStock(orderRequestDto.getSkuCode(), orderRequestDto.getQuantity());
        if (!inStock) {
            throw  new RuntimeException("Product Is Not In Stock");
        }

        Order entity = orderMapper.map(orderRequestDto);
        entity.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(entity);
        OrderResponseDto orderResponseDto = orderMapper.unMap(entity);
        return orderResponseDto;
    }

}
