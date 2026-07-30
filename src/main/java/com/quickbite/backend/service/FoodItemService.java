package com.quickbite.backend.service;

import com.quickbite.backend.entity.FoodItem;
import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.repository.FoodItemRepository;
import com.quickbite.backend.repository.RestaurantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean deleteFoodItemById(ObjectId id){
        foodItemRepository.deleteById(id);

        return true;
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
