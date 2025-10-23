package org.example.service;

import org.example.dto.AuthResponse;
import org.example.entity.User;
import org.example.exception.AuthenticationException;
import org.example.repository.AuthRepository;
import org.example.repository.UserRepository;
import org.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository repo;

    public AuthResponse login(String email, String password) {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new AuthenticationException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid password");
        }

        user.setPassword(null);
        String token = JwtUtil.generateToken(user.getEmail(), user.getRole());

        return new AuthResponse("Login successful", user,token);
    }


    public User save(User user) {
        return repo.save(user);
    }
}
