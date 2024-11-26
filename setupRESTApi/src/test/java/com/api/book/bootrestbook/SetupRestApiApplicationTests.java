package com.api.user.bootrestuser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.user.bootrestuser.entities.User;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    // Get all users
    public List<User> getAllUsers() {
        return users;
    }

    // Get user by ID
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    // Add a new user
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    // Delete user by ID
    public void deleteUser(int userId) {
        users.removeIf(user -> user.getId() == userId);
    }

    // Update user by ID
    public User updateUser(User user, int userId) {
        for (User u : users) {
            if (u.getId() == userId) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setDateOfBirth(user.getDateOfBirth());
                return u;
            }
        }
        return null;
    }
}
