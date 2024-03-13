package com.main.app.controller;

import com.main.app.doa.Teacherdao;
import com.main.app.entity.Student;
import com.main.app.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    Teacherdao teacherdao;
    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherdao.saveTeacher(teacher);
    }
    @PatchMapping("/updateTeacherName")
    public Teacher updateTeacherName(@RequestBody Teacher teacher){
        return teacherdao.updateTeacherName(teacher);
    }

    @PutMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return teacherdao.updateTeacher(teacher);
    }
    @GetMapping("/getTeacher/{id}")
    public Teacher getTeacher(@PathVariable("id") int id){
        return teacherdao.getByID(id);
    }
    @GetMapping("/getAllTeacher")
    public List<Teacher> getAllTeacher() {
        return teacherdao.allTeacher();
    }
    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable("id") int id){
        return teacherdao.deleteById(id);
    }
}
