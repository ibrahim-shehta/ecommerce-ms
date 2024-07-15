package com.hema.ms.order.service.impl;

import com.hema.ms.order.client.InventoryClient;
import com.hema.ms.order.dto.OrderRequestDto;
import com.hema.ms.order.dto.OrderResponseDto;
import com.hema.ms.order.mapper.OrderMapper;
import com.hema.ms.order.model.Order;
import com.hema.ms.order.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

/*
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
 */
    @InjectMocks
    OrderServiceImpl underTestService;
    @Mock
    InventoryClient inventoryClient;


    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;


    @Test
    public void testInsert_OutOfStock() throws Exception {
        // Mock data
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setQuantity(10);
        orderRequestDto.setSkuCode("SKU123");
        // Mock behavior
        when(inventoryClient.isInStock(orderRequestDto.getSkuCode(), orderRequestDto.getQuantity())).thenReturn(false);

        Assertions.assertThrows(RuntimeException.class, () -> underTestService.insert(orderRequestDto), "Product Is Not In Stock");
    }

    @Test
    public void testInsert_Success() throws Exception {
        // Mock data
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setQuantity(10);
        orderRequestDto.setSkuCode("SKU123");


        Order mockEntity = new Order();
        mockEntity.setQuantity(10);
        mockEntity.setSkuCode("SKU123");
        mockEntity.setId(1L);

        OrderResponseDto mockResponseDto = new OrderResponseDto();
        mockResponseDto.setQuantity(10);
        mockResponseDto.setSkuCode("SKU123");

        // Mock behavior
        when(inventoryClient.isInStock(orderRequestDto.getSkuCode(), orderRequestDto.getQuantity())).thenReturn(true);
        when(orderMapper.map(orderRequestDto)).thenReturn(mockEntity);
        when(orderMapper.unMap(mockEntity)).thenReturn(mockResponseDto);
        when(orderRepository.save(mockEntity)).thenReturn(mockEntity);

        // Call the method
        OrderResponseDto responseDto = underTestService.insert(orderRequestDto);

        // Assertions
        assertEquals(mockResponseDto, responseDto);
        verify(inventoryClient, times(1)).isInStock(orderRequestDto.getSkuCode(), orderRequestDto.getQuantity());
        verify(orderMapper, times(1)).map(orderRequestDto);
        verify(orderRepository, times(1)).save(mockEntity);
        verify(orderMapper, times(1)).unMap(mockEntity);
    }


}