package com.map.securityDemo.controller;

import com.map.securityDemo.dao.StudentDao;
import com.map.securityDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentDao.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return new ResponseEntity<>(studentDao.findById(id).orElse(null), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentDao.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        return new ResponseEntity<>("Student data deleted", HttpStatus.GONE);
    }
}
