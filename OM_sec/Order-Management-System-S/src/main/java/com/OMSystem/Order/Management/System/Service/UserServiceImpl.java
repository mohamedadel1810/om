package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.UserRequestDto;
import com.OMSystem.Order.Management.System.Dto.UserResponseDto;
import com.OMSystem.Order.Management.System.Entity.User;
import com.OMSystem.Order.Management.System.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
    @PreAuthorize("hasRole('Admin')")
    public ApiResponse<List<UserResponseDto>> findAll() {

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            return ApiResponse.fail("USER_NOT_FOUND",
                    "there are no users");
        }
        List<UserResponseDto> responseList = new ArrayList<>();

        for (User user : users) {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setRole(user.getRole());

            responseList.add(dto);


        }
        return ApiResponse.ok(responseList);
    }

        @Override
        @PreAuthorize("hasRole('Admin')")
        public ApiResponse<UserResponseDto> findById ( int userId){
            Optional<User> result = userRepository.findById(userId);

            if (result.isEmpty()) {
                return ApiResponse.fail("USER_NOT_FOUND",
                        "User with id " + userId + " not found");

            }
            User user = result.get();

            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setRole(user.getRole());

            return ApiResponse.ok(dto);
        }

        @Override
//    public User save(User user) {
//        return userRepository.save(user);
//    }
        @PreAuthorize("hasRole('Admin')")
        public ApiResponse<UserResponseDto> save (UserRequestDto dto){

            User user = new User();
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setRole(dto.getRole());

            User saved = userRepository.save(user);

            UserResponseDto response = new UserResponseDto();
            response.setId(saved.getId());
//            ///////////////////////////////////////////////////
            response.setEmail(saved.getEmail());
//            ///////////////////////////////////////////////////
            response.setUsername(saved.getUsername());
            response.setRole(saved.getRole());

            return ApiResponse.ok(response);

        }

        @Override
        @PreAuthorize("hasRole('Admin')")
        public ApiResponse<Void> deleteById ( int userId){
            Optional<User> result = userRepository.findById(userId);

            if (result.isPresent()) {
                userRepository.delete(result.get());
                return ApiResponse.okMessage("User deleted ");
            } else {
                return ApiResponse.fail(
                        "USER_NOT_FOUND",
                        "did not find user id"
                );
            }
        }

    @Override
    @PreAuthorize("hasRole('Admin')")
    public ApiResponse<UserResponseDto> update(int id, UserRequestDto dto) {
        Optional<User> result = userRepository.findById(id);

        if (result.isEmpty()) {
            return ApiResponse.fail(
                    "USER_NOT_FOUND",
                    "User with id " + id + " not found"
            );
        }

        User user = result.get();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User updated = userRepository.save(user);

        UserResponseDto response = new UserResponseDto();
        response.setId(updated.getId());
        response.setUsername(updated.getUsername());
        response.setRole(updated.getRole());

        return ApiResponse.ok(response);
    }
}
