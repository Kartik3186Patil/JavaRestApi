package com.example.RestApi.helper;

public class studentClass {
    private int id;
    private String firstName; // Changed to camelCase
    private String lastName;  // Changed to camelCase
    private String dept;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName; // Changed to camelCase
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName; // Changed to camelCase
    }
    public String getLastName() {
        return lastName; // Changed to camelCase
    }
    public void setLastName(String lastName) {
        this.lastName = lastName; // Changed to camelCase
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

}
