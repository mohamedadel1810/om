package com.OMSystem.Order.Management.System.Repo;

import com.OMSystem.Order.Management.System.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {



}
