package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.OrderItemRequestDto;
import com.OMSystem.Order.Management.System.Dto.OrderItemResponseDto;
import com.OMSystem.Order.Management.System.Entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    ApiResponse<List<OrderItemResponseDto>> findAll();

    ApiResponse<OrderItemResponseDto> findById(int id);

    ApiResponse<OrderItemResponseDto> save(OrderItemRequestDto orderItem);

    ApiResponse<OrderItemResponseDto> update(int id ,OrderItemRequestDto orderItemRequestDto);

    ApiResponse<Void> deleteById(int id);
}
