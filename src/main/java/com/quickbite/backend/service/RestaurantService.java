package com.quickbite.backend.service;

import com.quickbite.backend.repository.RestaurantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickbite.backend.entity.Restaurant;

import java.util.List;
import java.util.Optional;

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

    public Optional<Restaurant> getRestaurantById(ObjectId id){
        return restaurantRepository.findById(id);
    }

    public void deleteRestaurantById(ObjectId id){
        restaurantRepository.deleteById(id);
    }
}
