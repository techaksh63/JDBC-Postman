package com.main.app.controller;

import com.main.app.doa.Schooldao;
import com.main.app.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    Schooldao schooldao;
    @PostMapping("/addSchool")
    public School addSchool(@RequestBody School school){
        return schooldao.saveSchool(school);
    }

    @PutMapping("/updateSchool")
    public School updateSchool(@RequestBody School school){
        return schooldao.updateSchool(school);
    }
    @GetMapping("/getSchool/{registerNumber}")
    public School getSchool(@PathVariable("registerNumber") int registerNumber){
        return schooldao.getByRegisterNumber(registerNumber);
    }
    @GetMapping("/getAllSchool")
    public List<School> getAllSchool() {
        return schooldao.allSchool();
    }
    @DeleteMapping("/deleteSchool/{registerNumber}")
    public String deleteSchool(@PathVariable("registerNumber") int registerNumber){
        return schooldao.deleteByRegisterNumber(registerNumber);
    }

}
