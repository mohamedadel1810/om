package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.OrderItem;
import com.OMSystem.Order.Management.System.Repo.OrderItemRepository;
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
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
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
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
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
