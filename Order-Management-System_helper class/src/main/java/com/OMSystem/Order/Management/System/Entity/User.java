package com.OMSystem.Order.Management.System.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="User")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;


    @Column(name = "email", unique = true)
    @NotNull(message = "this field cannot be null")
    private String email;


    @Column(name = "password")
    @NotNull(message = "this field cannot be empty")
    @Min(value = 6, message = "min value is 6")
    @Max(value = 20, message = "max size is 20")
    private String password;


    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }
}