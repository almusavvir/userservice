package com.restalone.userservice.controller;

import com.restalone.userservice.model.User;
import com.restalone.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // ✅ GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // ✅ GET one user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return service.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // ✅ POST (Create)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    // ✅ PUT (Update)
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        return service.updateUser(id, updatedUser);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }

    // ✅ Custom filters
    @GetMapping("/gender/{gender}")
    public List<User> getUsersByGender(@PathVariable String gender) {
        return service.getUsersByGender(gender);
    }

    @GetMapping("/qualification/{qualification}")
    public List<User> getUsersByQualification(@PathVariable String qualification) {
        return service.getUsersByQualification(qualification);
    }

    @GetMapping("/access/{accesslevel}")
    public List<User> getUsersByAccessLevel(@PathVariable String accesslevel) {
        return service.getUsersByAccessLevel(accesslevel);
    }
}
