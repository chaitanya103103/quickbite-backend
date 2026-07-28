package com.quickbite.backend.controller;

import com.quickbite.backend.entity.User;
import com.quickbite.backend.repository.RestaurantRepository;
import com.quickbite.backend.repository.UserRepository;
import com.quickbite.backend.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable ObjectId id){
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            userService.saveEntry(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userName){

        try{
            User userInDb = userService.findByUserName(userName);
            if (userInDb != null){
                userInDb.setUserName(user.getUserName());
                userInDb.setPassword(user.getPassword());
                userInDb.setEmail(user.getEmail());
                userService.saveEntry(userInDb);
            }
            return new ResponseEntity<>(userInDb,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserByUsername(@PathVariable ObjectId id){
        try{
            userService.deleById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
