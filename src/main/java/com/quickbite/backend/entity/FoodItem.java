package com.quickbite.backend.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foodItem")
@Data
public class FoodItem {

    @Id
    private ObjectId id;

    private ObjectId restaurantId;

    private String name;

    private double price;
    
    private boolean available;
}