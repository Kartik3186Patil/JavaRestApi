package com.example.RestApi.controller;

import com.example.RestApi.entity.User;
import com.example.RestApi.entity.studentClass;
import com.example.RestApi.service.UserService;
import com.example.RestApi.service.studentClassService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/saveUser")
    public String createUSer(@RequestBody User user) {
        userService.saveEntry(user);
        return "New user is created";

    } 
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUSer(@RequestBody User user, @PathVariable String username) {
        User userInDB = userService.findByUserName(username);
        if (userInDB != null) {
            userInDB.setUsername(user.getUsername());
            userInDB.setPassword(user.getPassword());
            userService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}



