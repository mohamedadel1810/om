package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.User;

import java.util.List;

public interface UserService {


    ApiResponse<List<User>> findAll();

    ApiResponse<User> findById(int userId);

    ApiResponse<User> save(User user);

    ApiResponse<Void> deleteById(int userId);
}
