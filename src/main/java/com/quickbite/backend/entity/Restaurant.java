package com.quickbite.backend.entity;

import java.time.LocalTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "restaurants")
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


    public int getNumberOfChefs() {
        return numberOfChefs;
    }

    public int getActiveChefsToday() {
        return activeChefsToday;
    }

    public void setActiveChefsToday(int activeChefsToday) {
        this.activeChefsToday = activeChefsToday;
    }

    public void setNumberOfChefs(int numberOfChefs) {
        this.numberOfChefs = numberOfChefs;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public ObjectId getId() {
        return id;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


}
