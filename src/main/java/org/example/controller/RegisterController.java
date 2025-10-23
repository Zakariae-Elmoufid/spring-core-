package org.example.controller;


import org.example.entity.User;
import org.example.service.AuthService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AuthService authService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public User save(@RequestBody User user) {
        return authService.save(user);
    }
}
