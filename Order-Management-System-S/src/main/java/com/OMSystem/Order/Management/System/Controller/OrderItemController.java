package com.OMSystem.Order.Management.System.Controller;

import com.OMSystem.Order.Management.System.Entity.OrderItem;
import com.OMSystem.Order.Management.System.Entity.Product;
import com.OMSystem.Order.Management.System.Service.ApiResponse;
import com.OMSystem.Order.Management.System.Service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class OrderItemController {

    private OrderItemService orderItemService ;
         public OrderItemController (OrderItemService orderItemService)
         {
             this.orderItemService=orderItemService;
         }
         @GetMapping
    public ResponseEntity<ApiResponse<List<OrderItem>>>getAll(){
             return ResponseEntity.ok(orderItemService.findAll());
         }
         @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderItem>>getById(@PathVariable int id){
             return ResponseEntity.ok(orderItemService.findById(id));
         }
    @PostMapping
    public ResponseEntity<ApiResponse<OrderItem>> addProduct(@RequestBody OrderItem item){

        return ResponseEntity.ok(orderItemService.save(item));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderItem>>updateProduct (@PathVariable int id ,@RequestBody OrderItem item){
        item.setId(id);
             return ResponseEntity.ok(orderItemService.save(item));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteProduct(@PathVariable int id){
        return ResponseEntity.ok(orderItemService.deleteById(id));
    }


}
