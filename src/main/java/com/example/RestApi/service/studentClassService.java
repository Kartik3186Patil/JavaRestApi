package com.example.RestApi.service;

import com.example.RestApi.entity.User;
import com.example.RestApi.entity.studentClass;
import com.example.RestApi.repository.studentClassRepo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component

public class studentClassService {

    @Autowired
    private studentClassRepo studentClassRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(studentClass student, String username) {
        try{
            User user = userService.findByUserName(username);
            student.setDate(LocalDateTime.now());
            studentClass stud = studentClassRepository.save(student);
            user.getStudentClassList().add(stud);
            userService.saveEntry(user);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while saving the entry." ,e);
        }
    }

    public void saveEntry(studentClass student) {
        studentClassRepository.save(student);
    }

    public List<studentClass> getAll() {
        return studentClassRepository.findAll();
    }

    public Optional<studentClass> findById(ObjectId id) {
        return studentClassRepository.findById(id);
    }

    public void deleteById(ObjectId id, String userName) {
        User user =userService.findByUserName(userName);
        user.getStudentClassList().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        studentClassRepository.deleteById(id);
    }
}
