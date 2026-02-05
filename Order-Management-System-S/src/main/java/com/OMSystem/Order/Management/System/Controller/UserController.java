package com.OMSystem.Order.Management.System.Controller;

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
    public ResponseEntity<ApiResponse<List<User>>>getAll(){
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getById(@PathVariable int id){

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<User>> addUser(@RequestBody User user){
//        user.setId(0);
//        User user = new User();


        System.out.println("GetUser" + user.getUsername());
         return ResponseEntity.ok( userService.save(user));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@RequestBody User user ,@PathVariable int id){
        user.setId(id);
     return ResponseEntity.ok(userService.save(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteUser(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteById(id));
    }





}

