package com.quickbite.backend.controller;


import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public void createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.saveRestaurant(restaurant);
    }
}
