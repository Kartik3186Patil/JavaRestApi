package com.example.RestApi.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
public class studentClass {
    @Id
    private ObjectId id;  // Changed type to String
    private String firstName; // CamelCase
    private String lastName;  // CamelCase
    private String dept;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    private LocalDateTime date;



    // Getter and Setter for id
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName; // CamelCase
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName; // CamelCase
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName; // CamelCase
    }
    public void setLastName(String lastName) {
        this.lastName = lastName; // CamelCase
    }

    // Getter and Setter for dept
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
}
