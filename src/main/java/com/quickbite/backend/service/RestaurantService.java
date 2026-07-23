package com.quickbite.backend.service;

import com.quickbite.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickbite.backend.entity.Restaurant;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void saveRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }
}
