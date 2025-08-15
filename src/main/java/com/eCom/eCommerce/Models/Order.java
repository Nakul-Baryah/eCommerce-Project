package com.eCom.eCommerce.Models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private String userId;
    private String productId;
    private String productName;
    private Date orderDate;
    private Double price;
    private String status; // e.g., "Pending", "Shipped", "Delivered", "Cancelled"
    private String shippingAddress;
    private int quantity;
}
