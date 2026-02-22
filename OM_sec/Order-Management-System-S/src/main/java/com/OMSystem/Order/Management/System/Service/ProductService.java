package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.ProductRequestDto;
import com.OMSystem.Order.Management.System.Dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
   ApiResponse<List<ProductResponseDto>> findAll();

    ApiResponse<ProductResponseDto> findById(int id);

    ApiResponse<ProductResponseDto> save (ProductRequestDto dto);

    ApiResponse<ProductResponseDto> update(int id , ProductRequestDto dto);

    ApiResponse<Void> deleteById(int id);
}
