package com.snaply.order_tracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "CAKE_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String product;
    private String status;
    private LocalDateTime orderDate;
    private LocalDateTime updatedDate;


    @PrePersist
    public void prePersist() {
        if (status == null) status = "NEW";
        if (orderDate == null) orderDate = LocalDateTime.now();
        if (updatedDate == null) updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
