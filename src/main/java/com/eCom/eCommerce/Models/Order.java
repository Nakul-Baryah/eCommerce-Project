package com.eCom.eCommerce.Models;

import java.sql.Date;

import com.eCom.eCommerce.User.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String productId;
    private String productName;
    private Date orderDate;
    private Double price;
    private String status; // e.g., "Pending", "Shipped", "Delivered", "Cancelled"
    private String shippingAddress;
    private int quantity;
}
