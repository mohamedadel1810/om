package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    ApiResponse<Order> findById(int id );

    Order save(Order order);

    ApiResponse<Void> deleteById(int id);
}
