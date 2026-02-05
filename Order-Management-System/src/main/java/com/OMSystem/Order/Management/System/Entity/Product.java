package com.OMSystem.Order.Management.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "productName",nullable = false)
    private String productName;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name= "stockQuantity")
    private int stockQuantity;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems =new ArrayList<>();



}

