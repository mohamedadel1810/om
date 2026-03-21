package com.OMSystem.Order.Management.System.Repo;

import com.OMSystem.Order.Management.System.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {


}
