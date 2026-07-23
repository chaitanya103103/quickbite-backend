package com.quickbite.backend.controller;


import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
}
