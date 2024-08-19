package com.coffee.RoastyToasty.Dto;

import com.coffee.RoastyToasty.Entity.Customer;
import com.coffee.RoastyToasty.Entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    private Double totalPrice;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();
}
