package com.quickbite.backend.entity;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class OrderItem {
    private ObjectId foodItemId;

    private String foodName;

    private double priceAtOrder;

    private int quantity;

}


