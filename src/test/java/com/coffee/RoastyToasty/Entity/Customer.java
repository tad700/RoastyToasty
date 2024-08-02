package com.coffee.RoastyToasty.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private LocalDateTime createdAt = LocalDateTime.now();
}

