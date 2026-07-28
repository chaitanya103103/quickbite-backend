package com.quickbite.backend.controller;


import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.entity.User;
import com.quickbite.backend.service.RestaurantService;
import com.quickbite.backend.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurant();
    }

    @PostMapping("/{username}")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant,@PathVariable String username) {
        try{
            restaurantService.saveRestaurant(restaurant,username);
            return new ResponseEntity<>(restaurant,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsByUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<Restaurant> restaurant =  restaurantService.getAllRestaurant();
        if (restaurant != null && !restaurant.isEmpty()){
            return new ResponseEntity<>(restaurant,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable ObjectId id){
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isPresent()){
            return new ResponseEntity<>(restaurant.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/id/{username}/{id}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable ObjectId id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isPresent()){
            restaurantService.deleteRestaurantById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/id/{username}/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable ObjectId id,
                                    @RequestBody Restaurant restaurant){
        try {
            restaurantService.updateRestaurant(id, restaurant);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        }
}
