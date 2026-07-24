package com.quickbite.backend.controller;

import com.quickbite.backend.entity.FoodItem;
import com.quickbite.backend.service.FoodItemService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("foodItem")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public boolean saveFoodItem(@RequestBody FoodItem foodItem){
        foodItemService.saveFoodItem(foodItem);
        return true;
    }

    @GetMapping
    public List<FoodItem> getAllFoodItem(){
        return foodItemService.findALLFoodItem();
    }

    @GetMapping("/{id}")
    public Optional<FoodItem> getFoodItemById(@PathVariable ObjectId id){
        return foodItemService.findFoodItemById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFoodItemById(@PathVariable ObjectId id){
        foodItemService.deleteFoodItemById(id);
        return true;
    }

}
