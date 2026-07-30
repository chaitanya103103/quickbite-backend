package com.quickbite.backend.service;

import com.quickbite.backend.entity.User;
import com.quickbite.backend.repository.RestaurantRepository;
import com.quickbite.backend.repository.UserRepository;
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

    @Autowired
    private UserService userService;

    public void saveRestaurant(Restaurant restaurant, String userName){
        User user = userService.findByUserName(userName);
        Restaurant saved = restaurantRepository.save(restaurant);
        user.getRestaurants().add(saved);
        userService.saveEntry(user);
    }

    public void saveRestaurant(Restaurant restaurant) {
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

    public boolean updateRestaurant(ObjectId id, Restaurant updatedRestaurant){

        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);

        if (optionalRestaurant.isPresent()){
            Restaurant existingRestaurant = optionalRestaurant.get();

            existingRestaurant.setName(updatedRestaurant.getName());
            existingRestaurant.setPhone(updatedRestaurant.getPhone());
            existingRestaurant.setOwnerName(updatedRestaurant.getOwnerName());
            existingRestaurant.setAddress(updatedRestaurant.getAddress());
            existingRestaurant.setOpeningTime(updatedRestaurant.getOpeningTime());
            existingRestaurant.setClosingTime(updatedRestaurant.getClosingTime());
            existingRestaurant.setNumberOfChefs(updatedRestaurant.getNumberOfChefs());
            existingRestaurant.setActiveChefsToday(updatedRestaurant.getActiveChefsToday());

            restaurantRepository.save(existingRestaurant);

            return true;

        }
        return false;
    }
}
