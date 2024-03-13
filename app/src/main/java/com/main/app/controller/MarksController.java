package com.main.app.controller;

import com.main.app.doa.Markdao;
import com.main.app.entity.Marks;
import com.main.app.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarksController {
    @Autowired
    Markdao marksdao;
    @PostMapping("/addMarks")
    public Marks addMarks(@RequestBody Marks marks){
        return marksdao.saveMarks(marks);
    }

    @PutMapping("/updateMarks")
    public Marks updateMarks(@RequestBody Marks marks){
        return marksdao.updateMarks(marks);
    }
    @GetMapping("/getMarks/{rollNumber}")
    public Marks getMarks(@PathVariable("rollNumber") int rollNumber){
        return marksdao.getByRollNumber(rollNumber);
    }
    @GetMapping("/getAllMarks")
    public List<Marks> getAllMarks() {
        return marksdao.allMarks();
    }
    @DeleteMapping("/deleteMarks/{rollNumber}")
    public String deleteMarks(@PathVariable("rollNumber") int rollNumber){
        return marksdao.deleteByRollNumber(rollNumber);
    }

}
