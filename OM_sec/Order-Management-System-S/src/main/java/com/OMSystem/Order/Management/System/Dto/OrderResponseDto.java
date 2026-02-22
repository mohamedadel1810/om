package com.OMSystem.Order.Management.System.Dto;

import com.OMSystem.Order.Management.System.Entity.State;

public class OrderResponseDto {


    private int id ;
    private State state;
    private double price ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
