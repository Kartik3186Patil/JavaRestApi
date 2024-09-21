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

    @GetMapping("id/{myId}")
    public studentClass getStudentById(@PathVariable Integer myId){
        return student_map.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public String deleteStudent(@PathVariable Integer myId){
        student_map.remove(myId);
        return "Student with Id " + myId+ " is deleted";

    }
    @PutMapping("id/{myId}")
    public String updateStudent(@PathVariable Integer myId,@RequestBody studentClass student){
        student_map.put(myId,student);
        return "Student data updated successfully";
    }


}
