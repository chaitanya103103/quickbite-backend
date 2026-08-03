package com.quickbite.backend.service;

import com.quickbite.backend.controller.RestaurantController;
import com.quickbite.backend.entity.FoodItem;
import com.quickbite.backend.repository.FoodItemRepository;
import com.quickbite.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public RestaurantController restaurantRepository;

    @Autowired
    public FoodItemRepository foodItemRepository;

    
}
