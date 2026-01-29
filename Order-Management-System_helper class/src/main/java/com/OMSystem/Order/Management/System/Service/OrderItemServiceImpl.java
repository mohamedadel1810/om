package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.OrderItem;
import com.OMSystem.Order.Management.System.Repo.OrderItemRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

   private OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository ) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
//    public List<OrderItem> findAll() {
//        return orderItemRepository.findAll();
//    }
    public ApiResponse<List<OrderItem>> findAll(){

        List<OrderItem>orderItems =orderItemRepository.findAll();
        if (orderItems.isEmpty()){

            return ApiResponse.fail(
                    "NO_ITEMS_FOUND",
                    "there are no items"
            );
        }
        return ApiResponse.ok(orderItems);
    }

    @Override
    public ApiResponse<OrderItem> findById(int id) {
        Optional<OrderItem> result =orderItemRepository.findById(id);


        if (result.isPresent()){
            OrderItem orderItem=result.get();

            return ApiResponse.ok(orderItem);

        }
        else {

            return ApiResponse.fail(
                    "ORDER_ITEM_NOT_FOUND",
                    "did not find Order Item "
            );
        }

    }

    @Override
//    public OrderItem save(OrderItem orderItem) {
//        return orderItemRepository.save(orderItem);
//    }
    public ApiResponse<OrderItem>save(OrderItem orderItem){
        if (orderItem==null){
            return ApiResponse.fail("NO_ITEM_ADDED","invalid input");
        }
        OrderItem theorderItem = orderItemRepository.save(orderItem);
        return ApiResponse.ok(theorderItem);
    }

    @Override
    public ApiResponse<Void> deleteById(int id) {
        Optional<OrderItem> result = orderItemRepository.findById(id);
        if (result.isPresent()) {
            orderItemRepository.delete(result.get());
            return ApiResponse.okMessage("order item deleted");
        } else {
            return ApiResponse.fail("ORDER_ITEM_NOT_FOUND",
                    "did not find Order item");
        }


    }
}
