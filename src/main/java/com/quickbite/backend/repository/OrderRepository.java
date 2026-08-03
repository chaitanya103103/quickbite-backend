package com.quickbite.backend.repository;

import com.quickbite.backend.entity.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository {

    List<Order> findByUserId(ObjectId userId);
    List<Order> findByRestaurantId(ObjectId restaurantId);
}
