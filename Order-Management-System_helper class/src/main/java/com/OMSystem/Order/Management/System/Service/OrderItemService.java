package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    ApiResponse<List<OrderItem>> findAll();

    ApiResponse<OrderItem> findById(int id);

    ApiResponse<OrderItem> save(OrderItem orderItem);

    ApiResponse<Void> deleteById(int id);
}
