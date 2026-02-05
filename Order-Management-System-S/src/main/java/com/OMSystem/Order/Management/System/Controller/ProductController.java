package com.OMSystem.Order.Management.System.Controller;

import com.OMSystem.Order.Management.System.Entity.Product;
import com.OMSystem.Order.Management.System.Service.ApiResponse;
import com.OMSystem.Order.Management.System.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController (ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>>getAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> addProduct(@RequestBody Product product){

        return ResponseEntity.ok(productService.save(product));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>>updateProduct (@PathVariable int id ,@RequestBody Product product){
        product.setId(id);
        return ResponseEntity.ok(productService.save(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteProduct(@PathVariable int id){
        return ResponseEntity.ok(productService.deleteById(id));
    }

}
