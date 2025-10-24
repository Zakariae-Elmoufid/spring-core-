package org.example.controller;

import org.example.dto.AuthResponse;
import org.example.entity.User;
import org.example.service.AuthService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthService service;



    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody User user ) {
        AuthResponse response = service.login(user.getEmail(), user.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
