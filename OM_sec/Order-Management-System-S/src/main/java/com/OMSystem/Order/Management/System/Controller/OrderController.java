package com.OMSystem.Order.Management.System.Controller;

import com.OMSystem.Order.Management.System.Dto.OrderRequestDto;
import com.OMSystem.Order.Management.System.Dto.OrderResponseDto;
import com.OMSystem.Order.Management.System.Entity.Order;
import com.OMSystem.Order.Management.System.Service.ApiResponse;
import com.OMSystem.Order.Management.System.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService=orderService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDto>>getById(@PathVariable int id){
        return ResponseEntity.ok(orderService.findById(id));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponseDto>>addOrder(@RequestBody OrderRequestDto order){
        return ResponseEntity.ok(orderService.save(order));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDto>>save(@PathVariable int id ,@RequestBody OrderRequestDto order){

        return ResponseEntity.ok(orderService.update(id,order));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteById(@PathVariable int id){
        return ResponseEntity.ok(orderService.deleteById(id));
    }


    }

