package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    ApiResponse<Product> findById(int id);

    Product save (Product product);

    ApiResponse<Void> deleteById(int id);
}
