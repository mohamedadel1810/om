package com.OMSystem.Order.Management.System.Repo;

import com.OMSystem.Order.Management.System.Entity.Order;
import com.OMSystem.Order.Management.System.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {



}
