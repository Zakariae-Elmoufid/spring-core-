package org.example.controller;


import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> all() {
        return service.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return service.save(user);
    }


}
