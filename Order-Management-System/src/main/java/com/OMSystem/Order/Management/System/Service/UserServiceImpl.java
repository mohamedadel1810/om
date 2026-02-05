package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.User;
import com.OMSystem.Order.Management.System.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {



    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository TheuserRepository) {
        userRepository = TheuserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public ApiResponse<User> findById(int userId) {
        Optional<User> result = userRepository.findById(userId);

        if (result.isPresent()) {
            User theUser = result.get();
           return ApiResponse.ok(theUser);
        }
        else {
            return ApiResponse.fail(
                    "user not found",
                    "did not find user id "
            );
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ApiResponse<Void> deleteById(int  userId) {
        Optional<User> result = userRepository.findById(userId);

        if (result.isPresent()) {
            userRepository.delete(result.get());
            return ApiResponse.okMessage("User deleted ");
        }
        else {
            return ApiResponse.fail(
                    "USER_NOT_FOUND",
                    "did not find user id"
            );
        }
    }
}
