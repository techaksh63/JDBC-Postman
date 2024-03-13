package com.SpringProject.CRUDPostmanJDBCProject.controller;

import com.SpringProject.CRUDPostmanJDBCProject.dao.UserRepository;
import com.SpringProject.CRUDPostmanJDBCProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {

        return userRepository.saveUser(user);

    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {

        return userRepository.updateUser(user);

    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.getById(id);
    }

    @GetMapping("/allusers")
    public List<User> getUsers() {
        return userRepository.allUsers();
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userRepository.deleteById(id);
    }

}
