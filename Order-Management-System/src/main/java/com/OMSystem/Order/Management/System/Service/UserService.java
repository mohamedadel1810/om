package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.User;

import java.util.List;

public interface UserService {


    List<User>findAll();

    ApiResponse<User> findById(int userId);

    User save(User user);

    ApiResponse<Void> deleteById(int userId);
}
