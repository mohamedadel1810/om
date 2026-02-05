package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.Product;

import java.util.List;

public interface ProductService {
   ApiResponse<List<Product>> findAll();

    ApiResponse<Product> findById(int id);

    ApiResponse<Product> save (Product product);

    ApiResponse<Void> deleteById(int id);
}
