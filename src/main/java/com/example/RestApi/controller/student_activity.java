package com.example.RestApi.controller;

import com.example.RestApi.helper.studentClass;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class student_activity {
    Map<Integer, studentClass> student_map=new HashMap<Integer, studentClass>();

    @GetMapping("/displayStudentData")
    public List<studentClass>displayStudents(){
        return new ArrayList<>(student_map.values());
    }

    @PostMapping("/insertStudent")
    public String insertStudent(@RequestBody studentClass student){
        student_map.put(student.getId(),student);
        return "New student is inserted";


    }
}
