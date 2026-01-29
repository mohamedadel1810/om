package com.OMSystem.Order.Management.System.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name = "user_id")
    private Integer userId;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<OrderItem> items =new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
    }


    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "price",nullable = false)
    private int price ;


    @PrePersist
    void onCreate() {
//        this.createdAt = LocalDateTime.now();
        this.state = State.CREATED;
    }

    public void setId(int id) {
        this.id = id;
    }
}
