package com.example.RestApi.service;

import com.example.RestApi.entity.User;
import com.example.RestApi.entity.studentClass;
import com.example.RestApi.repository.UserRepo;
import com.example.RestApi.repository.studentClassRepo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class UserService {

    @Autowired
    public UserRepo UserRepository;
    public void saveEntry(User user ){
        UserRepository.save(user);
    }
    public List<User> getAll(){
        return UserRepository.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return UserRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        UserRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return UserRepository.findByUsername(userName);
    }
}
