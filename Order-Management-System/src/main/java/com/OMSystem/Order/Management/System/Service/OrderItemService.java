package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> findAll();

    ApiResponse<OrderItem> findById(int id);

    OrderItem save(OrderItem orderItem);

    ApiResponse<Void> deleteById(int id);
}
