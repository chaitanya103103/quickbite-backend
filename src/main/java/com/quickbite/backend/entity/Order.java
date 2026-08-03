package com.quickbite.backend.entity;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order {

    @Id
    private ObjectId id;

    private ObjectId RestaurantId;

    private ObjectId UserId;

    private List<OrderItem> items;

    private double totalAmount;

    private OrderStatus status;

    private LocalDateTime orderTime;

    private LocalDateTime estimatedReadyTime;
    
}
