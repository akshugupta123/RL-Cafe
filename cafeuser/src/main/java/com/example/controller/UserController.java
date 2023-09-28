package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.entity.User;
import com.example.services.IUserService;

import java.util.List;

@RestController
@Scope("request")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @GetMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<User> getAllUsers() {
        logger.debug("Fetching all users...");
        List<User> users = userService.getAllUsers();
        logger.debug("Fetched {} users.", users.size());
        return users;
    }

    @GetMapping(value = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public User getUserById(@PathVariable("id") Integer id) {
        logger.debug("Fetching user with ID: {}", id);
        User user = userService.getUserById(id);
        if (user != null) {
            logger.debug("Fetched user with ID {}: {}", id, user);
        } else {
            logger.debug("User with ID {} not found.", id);
        }
        return user;
    }

    @GetMapping(value = "/users/{email}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public User getUserByEmail(@PathVariable("email") String email) {
        logger.debug("Fetching user by email: {}", email);
        User user = userService.getUserByEmail(email);
        if (user != null) {
            logger.debug("Fetched user by email {}: {}", email, user);
        } else {
            logger.debug("User with email {} not found.", email);
        }
        return user;
    }

    @PostMapping(value = "/User", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        logger.debug("Adding a new user: {}", user);
        User addedUser = userService.addUser(user);
        logger.debug("Added user with ID {}: {}", addedUser.getId(), addedUser);
        return addedUser;
    }

    @PutMapping(value = "/User", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.OK)
    public User updateUser(@RequestBody User user) {
        logger.debug("Updating user with ID: {}", user.getId());
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            logger.debug("Updated user with ID {}: {}", updatedUser.getId(), updatedUser);
        } else {
            logger.debug("User with ID {} not found.", user.getId());
        }
        return updatedUser;
    }

    @DeleteMapping(value = "/User/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") Integer id) {
        logger.debug("Deleting user with ID: {}", id);
        userService.deleteUserById(id);
        logger.debug("User with ID {} deleted successfully.", id);
    }

    @PostMapping(value = "/User/login", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    public String loginUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> users = userService.getAllUsers();
        for (User user1 : users) {
            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
                logger.debug("Login successful for user: {}", username);
                return "Login successful!";
            }
        }
        logger.debug("Failed to login for user: {}", username);
        return "Failed to login. Invalid username or password";
    }
}
