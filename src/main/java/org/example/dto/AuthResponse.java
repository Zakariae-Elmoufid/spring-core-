package org.example.dto;

import org.example.entity.User;

public class AuthResponse {
    private String message;
    private User user;
    private String token;

    public AuthResponse(String message, User user,String token) {
        this.message = message;
        this.user = user;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
