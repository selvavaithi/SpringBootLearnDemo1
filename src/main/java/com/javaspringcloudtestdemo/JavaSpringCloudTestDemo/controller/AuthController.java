package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.dto.LoginRequest;
import com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth") // Base path for all authentication routes
public class AuthController {

    @PostMapping("/login") // POST /api/auth/login
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Verify Firebase token
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(loginRequest.getToken());
            String userName = decodedToken.getName();
            String userEmail = decodedToken.getEmail();

            LoginResponse response = new LoginResponse("Login successful", userName, userEmail);
            return ResponseEntity.ok(response);

        } catch (FirebaseAuthException e) {
            LoginResponse response = new LoginResponse("Invalid Firebase token", null, null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/logout") // POST /api/auth/logout
    public ResponseEntity<Map<String, String>> logout() {
        // Mock logout response (actual implementation depends on session/token management)
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user") // GET /api/auth/user
    public ResponseEntity<Map<String, String>> getUser(@RequestHeader("Authorization") String token) {
        try {
            // Remove "Bearer " prefix from the token
            String firebaseToken = token.replace("Bearer ", "");

            // Verify the Firebase token
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(firebaseToken);

            // Retrieve user details
            String userName = decodedToken.getName();  // User's name
            String userEmail = decodedToken.getEmail(); // User's email
            String profilePic = decodedToken.getPicture(); // User's profile picture (if available)

            // Create a response map
            Map<String, String> user = new HashMap<>();
            user.put("userName", userName);
            user.put("userEmail", userEmail);
            user.put("profilePic", profilePic != null ? profilePic : "https://via.placeholder.com/40");

            return ResponseEntity.ok(user);
        } catch (FirebaseAuthException e) {
            // Handle invalid token or any Firebase exception
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid or expired Firebase token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }
}
