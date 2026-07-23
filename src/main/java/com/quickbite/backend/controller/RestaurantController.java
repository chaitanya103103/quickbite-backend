package com.quickbite.backend.controller;


import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.service.RestaurantService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public boolean createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.saveRestaurant(restaurant);
        return true;
    }
    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable ObjectId id){
        return restaurantService.getRestaurantById(id);
    }
}
