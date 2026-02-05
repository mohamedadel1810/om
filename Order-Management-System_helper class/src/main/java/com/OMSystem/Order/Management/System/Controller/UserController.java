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
    public List<User>getAll(){
        return userService.findAll();
    }


    @GetMapping("/api/users/user{id}")
    public ResponseEntity<ApiResponse<User>> getById(@PathVariable int id){

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        user.setId(0);
        User newUser =userService.save(user);
        return newUser;
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        User theUser = userService.save(user);
        return theUser;
    }


    @DeleteMapping("/api/users/user{id}")
    public ResponseEntity<ApiResponse<Void>>deleteUser(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteById(id));
    }





}

