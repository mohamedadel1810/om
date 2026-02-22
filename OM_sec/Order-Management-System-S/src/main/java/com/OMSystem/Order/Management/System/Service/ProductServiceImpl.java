package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.ProductRequestDto;
import com.OMSystem.Order.Management.System.Dto.ProductResponseDto;
import com.OMSystem.Order.Management.System.Entity.Product;
import com.OMSystem.Order.Management.System.Repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ApiResponse<List<ProductResponseDto>> findAll() {
        List<Product>products =productRepository.findAll();
        if (products.isEmpty()){
            return ApiResponse.fail("PRODUCTS_NOT_FOUND",
                    "products not found");
        }
        List<ProductResponseDto> response = new ArrayList<>();

        for (Product product : products) {
            ProductResponseDto dto = new ProductResponseDto();
            dto.setId(product.getId());
            dto.setName(product.getProductName());
            dto.setPrice(product.getPrice());
            response.add(dto);
        }

        return ApiResponse.ok(response);
    }

    @Override
    public ApiResponse<ProductResponseDto> findById(int id) {
        Optional<Product> result = productRepository.findById(id);

        if (result.isEmpty()) {
            return ApiResponse.fail("Product_NOT_FOUND",
                    "Product with id " + id + " not found");

        }
        Product product = result.get();

        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getProductName());
        dto.setPrice(product.getPrice());

        return ApiResponse.ok(dto);
    }

    @Override
//    public Product save(Product product) {
//        return productRepository.save(product);
//    }
    public ApiResponse<ProductResponseDto> save(ProductRequestDto dto){
        Product product = new Product();
        product.setProductName(dto.getName());
        product.setPrice(dto.getPrice());

        Product saved = productRepository.save(product);

        ProductResponseDto response = new ProductResponseDto();
        response.setId(saved.getId());
        response.setName(saved.getProductName());
        response.setPrice(saved.getPrice());

        return ApiResponse.ok(response);
    }

    @Override
    public ApiResponse<ProductResponseDto> update(int id, ProductRequestDto dto) {
        Optional<Product> result = productRepository.findById(id);

        if (result.isEmpty()) {
            return ApiResponse.fail("PRODUCT_NOT_FOUND", "Product not found");
        }

        Product product = result.get();
        product.setProductName(dto.getName());
        product.setPrice(dto.getPrice());

        Product updated = productRepository.save(product);

        ProductResponseDto response = new ProductResponseDto();
        response.setId(updated.getId());
        response.setName(updated.getProductName());
        response.setPrice(updated.getPrice());

        return ApiResponse.ok(response);
    }

    @Override
    public ApiResponse<Void> deleteById (int id) {

        Optional<Product> result =productRepository.findById(id);
        if (result.isPresent()){

            productRepository.delete(result.get());
            return ApiResponse.okMessage("User deleted");
        }
        else {
            return ApiResponse.fail("PRODUCT_NOT_FOUND",
                    "did not find user id");
        }
    }
}
