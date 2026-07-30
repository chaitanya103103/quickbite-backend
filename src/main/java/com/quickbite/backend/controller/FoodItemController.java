package com.quickbite.backend.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.quickbite.backend.entity.FoodItem;
import com.quickbite.backend.service.FoodItemService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("foodItem")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/{id}")
    public ResponseEntity<FoodItem> saveFoodItem(@RequestBody FoodItem foodItem, @PathVariable ObjectId id){
        try {
            foodItemService.saveFoodItem(foodItem,id);
            return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoodItem(){
        List<FoodItem> foodItem = foodItemService.findALLFoodItem();
        if(foodItem.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(foodItem,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable ObjectId id){
        Optional<FoodItem> foodItem = foodItemService.findFoodItemById(id);
        if(foodItem.isPresent()){
            return new ResponseEntity<>(foodItem.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteFoodItemById(@PathVariable ObjectId id){
        Optional<FoodItem> foodItem =foodItemService.findFoodItemById(id);
        if(foodItem.isPresent()){
            foodItemService.deleteFoodItemById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable String id,
                                  @RequestBody FoodItem foodItem){
        try {
            foodItemService.updateFoodItem(new ObjectId(id), foodItem);
            return new ResponseEntity<>(foodItem,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
