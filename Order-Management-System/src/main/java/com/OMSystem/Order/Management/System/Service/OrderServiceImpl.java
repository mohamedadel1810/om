package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Entity.Order;
import com.OMSystem.Order.Management.System.Repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public ApiResponse<Order> findById(int id) {
         Optional<Order> result =orderRepository.findById(id);

         if (result.isPresent()){
             Order order = result.get();
             return ApiResponse.ok(order);
         }
         else {
             return ApiResponse.fail(
                     "ORDER_NOT_FOUND",
                     "Order not found"
             );
         }
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public ApiResponse<Void> deleteById(int id) {

        Optional<Order> result =orderRepository.findById(id);
        if (result.isPresent()){
            orderRepository.delete(result.get());
            return ApiResponse.okMessage("order deleted");
        }
        else {return ApiResponse.fail("ORDER_NOT_FOUND",
                "did not find user id");}
    }
}
