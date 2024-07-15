package com.hema.ms.order.mapper;

import com.hema.ms.order.dto.OrderRequestDto;
import com.hema.ms.order.dto.OrderResponseDto;
import com.hema.ms.order.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order map(OrderRequestDto dto);

    OrderResponseDto unMap(Order entity);

    List<OrderResponseDto> unMap(List<Order> entity);
}
