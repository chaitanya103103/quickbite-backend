package com.quickbite.backend.service;

import com.quickbite.backend.entity.FoodItem;
import com.quickbite.backend.repository.FoodItemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public void saveFoodItem(FoodItem foodItem){
        foodItemRepository.save(foodItem);
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
}
