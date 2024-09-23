package com.example.RestApi.controller;

import com.example.RestApi.entity.studentClass;
import com.example.RestApi.service.studentClassService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class student_activity_controller_v2 {

    @Autowired
    private studentClassService studentClassServe;

    @GetMapping("/displayStudentData")
    public ResponseEntity<?> displayStudents(){
        List<studentClass> stCLass=   studentClassServe.getAll();
        if(!stCLass.isEmpty() && stCLass!=null){
            return new ResponseEntity<>(stCLass,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/insertStudent")
    public ResponseEntity<studentClass> insertStudent(@RequestBody studentClass student){
        try{
            student.setDate(LocalDateTime.now());
            studentClassServe.saveEntry(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<studentClass> getStudentById(@PathVariable ObjectId myId){
        Optional<studentClass> StudentClass = studentClassServe.findById(myId);
        if(StudentClass.isPresent()){
            return new ResponseEntity<>(StudentClass.get(), HttpStatus.OK);
        }
       return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteStudent(@PathVariable ObjectId myId){
        studentClassServe.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateStudent(@PathVariable ObjectId myId,@RequestBody studentClass newStudent){
        studentClass old=studentClassServe.findById(myId).orElse(null);
        if(old!=null){
            old.setFirstName(newStudent.getFirstName()!=null && !newStudent.getFirstName().equals("")?newStudent.getFirstName(): old.getFirstName());
            old.setLastName(
                    newStudent.getLastName() != null && !newStudent.getLastName().equals("")
                            ? newStudent.getLastName()
                            : old.getLastName()
            );
            old.setDept(
                    newStudent.getDept() != null && !newStudent.getDept().equals("")
                            ? newStudent.getDept()
                            : old.getDept()
            );
            studentClassServe.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }


    }



