package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.dto;


public class LoginRequest {
    private String email;
    private String password;
    private String token;


    // Constructors
    public LoginRequest() {}

    public LoginRequest(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;

    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

