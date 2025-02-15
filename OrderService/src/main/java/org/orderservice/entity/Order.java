package org.orderservice.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDate orderDate;

    private String status;

    // Storing userId instead of full User to avoid tight coupling between services
    private Integer userId;

    private Integer productId;

    private Integer quantity;

    public Order(LocalDate orderDate, String status, Integer userId, Integer productId, Integer quantity) {
        this.orderDate = orderDate;
        this.status = status;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order(LocalDate orderDate, String status, Integer userId) {
        this.orderDate = orderDate;
        this.status = status;
        this.userId = userId;
    }

    public Order() {

    }

    public Order(Integer userId, Integer productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
