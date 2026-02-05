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
//    public List<Order> findAll() {
//        return orderRepository.findAll();
//    }
public ApiResponse<List<Order>> findAll(){
        List<Order> orders=orderRepository.findAll();
        if (orders.isEmpty()){

            return ApiResponse.fail("ORDERS_NOT_FOUND","There are not any orders");
        }
        return ApiResponse.ok(orders);

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
//    public Order save(Order order) {
//        return orderRepository.save(order);
//    }
    public ApiResponse<Order> save(Order order){

        if (order==null){
            return ApiResponse.fail("NO_ORDER_IS_ADDED","invalid input");
        }
        Order theOrder=orderRepository.save(order);
        return ApiResponse.ok(theOrder);
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
