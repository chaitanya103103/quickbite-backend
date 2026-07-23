package com.quickbite.backend.service;

import com.quickbite.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickbite.backend.entity.Restaurant;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void saveRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }
}
