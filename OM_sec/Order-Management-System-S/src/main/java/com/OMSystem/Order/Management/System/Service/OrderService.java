package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.OrderRequestDto;
import com.OMSystem.Order.Management.System.Dto.OrderResponseDto;
import com.OMSystem.Order.Management.System.Entity.Order;

import java.util.List;

public interface OrderService {
   ApiResponse<List<OrderResponseDto>> findAll();

    ApiResponse<OrderResponseDto> findById(int id );

    ApiResponse<OrderResponseDto> save(OrderRequestDto dto);
    ApiResponse<OrderResponseDto> update(int id ,OrderRequestDto dto);
    ApiResponse<Void> deleteById(int id);
}
