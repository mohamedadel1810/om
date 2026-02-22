package com.OMSystem.Order.Management.System.Service;

import com.OMSystem.Order.Management.System.Dto.OrderItemRequestDto;
import com.OMSystem.Order.Management.System.Dto.OrderItemResponseDto;
import com.OMSystem.Order.Management.System.Entity.OrderItem;
import com.OMSystem.Order.Management.System.Repo.OrderItemRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ApiResponse<List<OrderItemResponseDto>> findAll(){

        List<OrderItem>orderItems =orderItemRepository.findAll();
        if (orderItems.isEmpty()){

            return ApiResponse.fail(
                    "NO_ITEMS_FOUND",
                    "there are no items"
            );
        }
        List<OrderItemResponseDto> responseDtos =new ArrayList<>();

        for (OrderItem orderItem :orderItems){

            OrderItemResponseDto responseDto =new OrderItemResponseDto();
            responseDto.setPrice(orderItem.getPrice());
            responseDto.setQuantity(orderItem.getQuantity());
            responseDtos.add(responseDto);

        }

        return ApiResponse.ok(responseDtos);
    }

    @Override
    public ApiResponse<OrderItemResponseDto> findById(int id) {
        Optional<OrderItem> result =orderItemRepository.findById(id);


        if (result.isEmpty()){

            return ApiResponse.fail("ITEMS_NOT_FOUND","Items with this id not found");

        }

        OrderItem item =result.get();

        OrderItemResponseDto dto =new OrderItemResponseDto();
        dto.setQuantity(dto.getQuantity());
        dto.setPrice(dto.getPrice());

        return ApiResponse.ok(dto);


    }

    @Override
//    public OrderItem save(OrderItem orderItem) {
//        return orderItemRepository.save(orderItem);
//    }
    public ApiResponse<OrderItemResponseDto>save(OrderItemRequestDto orderItemDto){
        OrderItem item =new OrderItem();

        item.setQuantity(orderItemDto.getQuantity());

        OrderItem savedItem =orderItemRepository.save(item);

        OrderItemResponseDto responseDto =new OrderItemResponseDto();
        responseDto.setQuantity(savedItem.getQuantity());

        return ApiResponse.ok(responseDto);

    }



    @Override
    public ApiResponse<OrderItemResponseDto> update(int id ,OrderItemRequestDto itemRequestDto)
    {
        Optional<OrderItem> result =orderItemRepository.findById(id);


        if (result.isEmpty()){

            return ApiResponse.fail("ITEM_NOT FOUND","Item with this id not found");


        }
        OrderItem item =new OrderItem();
        item.setQuantity(itemRequestDto.getQuantity());


        OrderItem updatedItem = orderItemRepository.save(item);

        OrderItemResponseDto responseDto =new OrderItemResponseDto();
        responseDto.setQuantity(updatedItem.getQuantity());

        return ApiResponse.ok(responseDto);

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
