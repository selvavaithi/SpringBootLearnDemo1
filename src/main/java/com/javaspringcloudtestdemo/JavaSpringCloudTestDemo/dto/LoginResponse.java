package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.dto;

public class LoginResponse {
    private String message;
    private String userName;
    private String userEmail;

    // Constructors
    public LoginResponse() {}

    public LoginResponse(String message, String userName, String userEmail) {
        this.message = message;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

