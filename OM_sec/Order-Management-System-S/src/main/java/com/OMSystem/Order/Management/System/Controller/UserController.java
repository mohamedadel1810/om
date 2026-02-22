package com.OMSystem.Order.Management.System.Controller;

import com.OMSystem.Order.Management.System.Dto.UserRequestDto;
import com.OMSystem.Order.Management.System.Dto.UserResponseDto;
import com.OMSystem.Order.Management.System.Entity.User;
import com.OMSystem.Order.Management.System.Service.ApiResponse;
import com.OMSystem.Order.Management.System.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>>getAll(){
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getById(@PathVariable int id){

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<UserResponseDto>> addUser(@RequestBody UserRequestDto dto){
//        user.setId(0);
//        User user = new User();


//        System.out.println("GetUser" + user.getUsername());
         return ResponseEntity.ok( userService.save(dto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@RequestBody UserRequestDto dto ,@PathVariable int id){

     return ResponseEntity.ok(userService.update(id,dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteUser(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteById(id));
    }





}

