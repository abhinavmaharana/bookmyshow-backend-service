package com.bookmyshow.platform.controller;

import com.bookmyshow.platform.model.User;
import com.bookmyshow.platform.repository.UserRepository;
import com.bookmyshow.platform.util.PasswordHashingUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        try {
            if (userRepository.findByEmailAddress(user.getEmailAddress()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is already in use. Please try again");
            }

            String hashedPassword = PasswordHashingUtil.hashPassword(user.getPassword());
            user.setPassword(hashedPassword);
            User savedUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (NoSuchAlgorithmException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error hashing password");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            try {
                if (PasswordHashingUtil.verifyPassword(user.getPassword(), existingUser.getPassword())) {
                    // Passwords match, login successful
                    return ResponseEntity.ok("Login successful");
                } else {
                    // Passwords don't match
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
                }
            } catch (NoSuchAlgorithmException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error verifying password");
            }
        } else {
            // User not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}