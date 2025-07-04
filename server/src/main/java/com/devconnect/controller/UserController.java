package com.devconnect.controller;

import com.devconnect.model.User;
import com.devconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser() {
        // Assuming you have a way to get the authenticated user's ID
        UUID userId = userService.getCurrentAuthenticatedUserId();
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/me")
    public ResponseEntity<User> updateCurrentUserProfile(@RequestBody User userDetails) {
        // Assuming you have a way to get the authenticated user's ID
        UUID userId = userService.getCurrentAuthenticatedUserId();
        User updatedUser = userService.updateUserProfile(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}