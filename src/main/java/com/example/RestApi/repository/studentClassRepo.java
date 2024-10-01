package com.example.RestApi.repository;

import com.example.RestApi.entity.studentClass;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentClassRepo extends MongoRepository<studentClass, ObjectId> {

}
