package com.quickbite.backend.service;

import com.quickbite.backend.entity.FoodItem;
import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.repository.FoodItemRepository;
import com.quickbite.backend.repository.RestaurantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    public void saveFoodItem(FoodItem foodItem,ObjectId id){
        Restaurant restaurant = restaurantRepository.findRestaurantById(id);
        FoodItem saved = foodItemRepository.save(foodItem);
        restaurant.getFoodItems().add(saved);
        restaurantService.saveRestaurant(restaurant);
    }

    public List<FoodItem> findALLFoodItem(){
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> findFoodItemById(ObjectId id){
        return foodItemRepository.findById(id);
    }

    @Transactional
    public void deleteFoodItemById(ObjectId id){
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);
        if(foodItem.isPresent()){
            Optional<Restaurant> restaurant = restaurantService.getRestaurantById(foodItem.get().getRestaurantId());
            if (restaurant.isPresent()){
                restaurant.get().getFoodItems().removeIf(x -> x.getId().equals(id));
                restaurantService.saveRestaurant(restaurant.get());
                foodItemRepository.deleteById(id);
            }
        }
    }

    public boolean updateFoodItem(ObjectId id ,FoodItem updatedFoodItem){
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(id);

        if (optionalFoodItem.isPresent()){
            FoodItem existingFoodItem = optionalFoodItem.get();

            existingFoodItem.setName(updatedFoodItem.getName());
            existingFoodItem.setPrice(updatedFoodItem.getPrice());
            existingFoodItem.setAvailable(updatedFoodItem.isAvailable());

            foodItemRepository.save(existingFoodItem);
            return true;
        }
        return false;
    }


}
