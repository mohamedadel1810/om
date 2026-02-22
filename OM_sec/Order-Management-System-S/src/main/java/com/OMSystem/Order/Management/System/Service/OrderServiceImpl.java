package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.OrderRequestDto;
import com.OMSystem.Order.Management.System.Dto.OrderResponseDto;
import com.OMSystem.Order.Management.System.Entity.Order;
import com.OMSystem.Order.Management.System.Entity.Product;
import com.OMSystem.Order.Management.System.Repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public ApiResponse<List<OrderResponseDto>> findAll(){
        List<Order> orders=orderRepository.findAll();
        if (orders.isEmpty()){

            return ApiResponse.fail("ORDERS_NOT_FOUND","There are not any orders");
        }
        List<OrderResponseDto> responseDtos =new ArrayList<>();

        for (Order order : orders){

            OrderResponseDto dto =new OrderResponseDto();
            dto.setId(order.getId());
            dto.setPrice(order.getPrice());
            dto.setState(order.getState());
            responseDtos.add(dto);
        }
        return ApiResponse.ok(responseDtos);

    }
    @Override
    public ApiResponse<OrderResponseDto> findById(int id) {
        Optional<Order> result = orderRepository.findById(id);

        if (result.isEmpty()) {
            return ApiResponse.fail("ORDER_NOT_FOUND",
                    "Product with id" + id + "not found");
        }
        Order order = result.get();

        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setPrice(order.getPrice());
        dto.setState(order.getState());
        return ApiResponse.ok(dto);

    }

    @Override
//    public Order save(Order order) {
//        return orderRepository.save(order);
//    }
    public ApiResponse<OrderResponseDto> save(OrderRequestDto dto){

        Order order=new Order();
        order.setId(dto.getOrderId());
        order.setPrice(dto.getPrice());
        order.setItems(dto.getItems());

        Order savedOrder =orderRepository.save(order);

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(savedOrder.getId());
        responseDto.setPrice(savedOrder.getPrice());

        return ApiResponse.ok(responseDto);
    }

    @Override
    public ApiResponse<OrderResponseDto> update(int id, OrderRequestDto dto) {
        Optional<Order> result= orderRepository.findById(id);

        if (result.isEmpty()){

            return ApiResponse.fail("ORDER_NOT_FOUND","order not found");

        }

        Order order= result.get();
        order.setState(dto.getState());
        order.setPrice(dto.getPrice());
        order.setItems(dto.getItems());

        Order updatedOrder1 =orderRepository.save(order);

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(updatedOrder1.getId());
        responseDto.setPrice(updatedOrder1.getPrice());
        responseDto.setState(updatedOrder1.getState());

        return ApiResponse.ok(responseDto);

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
