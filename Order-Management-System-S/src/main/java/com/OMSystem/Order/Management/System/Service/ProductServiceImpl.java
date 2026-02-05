package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.Product;
import com.OMSystem.Order.Management.System.Repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ApiResponse<List<Product>> findAll() {
        List<Product>products =productRepository.findAll();
        if (products.isEmpty()){
            return ApiResponse.fail("PRODUCTS_NOT_FOUND",
                    "products not found");
        }
        return ApiResponse.ok(products);
    }

    @Override
    public ApiResponse<Product> findById(int id) {
         Optional<Product> result=productRepository.findById(id);

         if (result.isPresent()){
             Product Theproduct =result.get();
             return ApiResponse.ok(Theproduct);

         }
         else {
          return ApiResponse.fail("PRODUCT_NOT_FOUND", "Product not found");
         }
    }

    @Override
//    public Product save(Product product) {
//        return productRepository.save(product);
//    }
    public ApiResponse<Product> save(Product product){
        if (product==null){
            return ApiResponse.fail("NO_PRODUCT_ADDED","invalid input");
        }
        Product theproduct = productRepository.save(product);
        return ApiResponse.ok(theproduct);
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
