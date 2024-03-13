package com.main.app.controller;

import com.main.app.doa.Studentdoa;
import com.main.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    Studentdoa studentdoa;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
       return studentdoa.saveStudent(student);
    }

    @PatchMapping("/updateStudentName")
    public Student updateStudentName(@RequestBody Student student){
        return studentdoa.updateStudentName(student);
    }
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        return studentdoa.updateStudent(student);
    }

    @GetMapping("/getStudent/{rollNumber}")
    public Student getStudent(@PathVariable("rollNumber") int rollNumber){
      return studentdoa.getByID(rollNumber);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentdoa.allStudent();
    }
    @DeleteMapping("/deleteStudent/{rollNumber}")
    public String deleteStudent(@PathVariable("rollNumber") int rollNumber){
        return studentdoa.deleteById(rollNumber);
    }

}
