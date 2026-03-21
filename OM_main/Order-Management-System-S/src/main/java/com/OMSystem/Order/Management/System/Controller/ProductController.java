package com.OMSystem.Order.Management.System.Controller;

import com.OMSystem.Order.Management.System.Dto.ProductRequestDto;
import com.OMSystem.Order.Management.System.Dto.ProductResponseDto;
import com.OMSystem.Order.Management.System.Service.ApiResponse;
import com.OMSystem.Order.Management.System.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class    ProductController {
    private ProductService productService;

    public ProductController (ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>>getAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<ProductResponseDto>> addProduct(@RequestBody ProductRequestDto dto){

        return ResponseEntity.ok(productService.save(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>>updateProduct (@PathVariable int id ,@RequestBody ProductRequestDto dto ){

        return ResponseEntity.ok(productService.update(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>deleteProduct(@PathVariable int id){
        return ResponseEntity.ok(productService.deleteById(id));
    }

}
