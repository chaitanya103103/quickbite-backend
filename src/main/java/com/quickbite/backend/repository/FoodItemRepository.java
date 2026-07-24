package com.quickbite.backend.repository;

import com.quickbite.backend.entity.FoodItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemRepository extends MongoRepository<FoodItem, ObjectId> {

}
