package com.quickbite.backend.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "restaurants")
@Data
public class Restaurant {

    @Id
    private ObjectId id;

    private String name;

    private String ownerName;

    private String phone;

    private String address;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private int numberOfChefs;

    private int activeChefsToday;

    @DBRef
    private List<FoodItem> foodItems = new ArrayList<>();


}