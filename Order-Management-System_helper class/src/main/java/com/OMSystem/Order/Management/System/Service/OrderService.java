package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.Order;

import java.util.List;

public interface OrderService {
   ApiResponse<List<Order>> findAll();

    ApiResponse<Order> findById(int id );

    ApiResponse<Order> save(Order order);

    ApiResponse<Void> deleteById(int id);
}
