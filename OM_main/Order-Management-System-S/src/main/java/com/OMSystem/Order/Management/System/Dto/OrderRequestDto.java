package com.OMSystem.Order.Management.System.Dto;

import com.OMSystem.Order.Management.System.Entity.OrderItem;
import com.OMSystem.Order.Management.System.Entity.State;

import java.util.List;

public class OrderRequestDto {


    private int userId;

    private int productId;
    private int quantity;

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

//    public List<OrderItem> getOitems() {
//        return Oitems;
//    }

//    public void setOitems(List<OrderItem> oitems) {
//        Oitems = oitems;
//    }

    public int getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private List<OrderItemRequestDto> items;
    private List<OrderItem> Oitems;

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<OrderItem> getItems() {
        return Oitems;
    }

    public void setItems(List<OrderItemRequestDto> items) {
        this.items = items;
    }

}
