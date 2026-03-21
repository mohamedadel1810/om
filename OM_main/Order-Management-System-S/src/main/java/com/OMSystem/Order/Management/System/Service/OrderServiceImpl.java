package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.OrderRequestDto;
import com.OMSystem.Order.Management.System.Dto.OrderResponseDto;
import com.OMSystem.Order.Management.System.Entity.Order;
import com.OMSystem.Order.Management.System.Entity.OrderItem;
import com.OMSystem.Order.Management.System.Entity.Product;
import com.OMSystem.Order.Management.System.Entity.User;
import com.OMSystem.Order.Management.System.Repo.OrderItemRepository;
import com.OMSystem.Order.Management.System.Repo.OrderRepository;
import com.OMSystem.Order.Management.System.Repo.ProductRepository;
import com.OMSystem.Order.Management.System.Repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private OrderItemRepository orderItemRepository;
    private UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            OrderItemRepository orderItemRepository,
            UserRepository userRepository){
        this.orderRepository =orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository=userRepository;
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

//    public Order save(Order order) {
//        return orderRepository.save(order);
//    }
@Override
    public ApiResponse<OrderResponseDto> save(List<OrderRequestDto> dto){
//        if (dto.isEmpty()){
//            return ApiResponse.fail("Empty_order", "Order is empty");
//        }

//        Optional<User> userOptional = userRepository.findById(dto.get(0).getUserId());
//
//
//        if (userOptional.isEmpty()){
//            return ApiResponse.fail("USER_NOT_FOUND","user not found");
//        }
//        User user =userOptional.get();

        Order order=new Order();
//
//dto.get(0).getId
        order.setUser(dto.get(0).getUserId());
//
//
        order.setPrice(0);
        order = orderRepository.save(order);


        Double total = 0.0;

        for(OrderRequestDto orderItemDto : dto) {
            Optional<Product> productOptional = productRepository.findById(orderItemDto.getProductId());
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(orderItemDto.getQuantity());
                orderItem.setProduct(orderItemDto.getProductId());

                total += orderItemDto.getQuantity() * product.getPrice();

                orderItem.setOrder(order.getId());
                orderItemRepository.save(orderItem);
            }
        }
        /*order.setId(dto.getOrderId());
        order.setPrice(dto.getPrice());
        order.setItems(dto.getItems());
*/
        order.setPrice(total);
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

      /*  Order order= result.get();
        order.setState(dto.getState());
        order.setPrice(dto.getPrice());
        order.setItems(dto.getItems());

        Order updatedOrder1 =orderRepository.save(order);

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(updatedOrder1.getId());
        responseDto.setPrice(updatedOrder1.getPrice());
        responseDto.setState(updatedOrder1.getState());*/

        return ApiResponse.ok(new OrderResponseDto());

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
