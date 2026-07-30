package com.quickbite.backend.repository;

import com.quickbite.backend.entity.Restaurant;
import com.quickbite.backend.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, ObjectId> {
    Restaurant findRestaurantById(ObjectId id);
}
