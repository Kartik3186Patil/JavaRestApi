package com.example.RestApi.repository;

import com.example.RestApi.entity.User;
import com.example.RestApi.entity.studentClass;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
        User findByUsername(String username);
}
