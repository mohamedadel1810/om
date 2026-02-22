package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.UserRequestDto;
import com.OMSystem.Order.Management.System.Dto.UserResponseDto;
import com.OMSystem.Order.Management.System.Entity.User;

import java.util.List;

public interface UserService {


    ApiResponse<List<UserResponseDto>> findAll();

    ApiResponse<UserResponseDto> findById(int userId);

    ApiResponse<UserResponseDto> save(UserRequestDto user);

    ApiResponse<Void> deleteById(int userId);

    ApiResponse<UserResponseDto> update(int id, UserRequestDto dto);
}
