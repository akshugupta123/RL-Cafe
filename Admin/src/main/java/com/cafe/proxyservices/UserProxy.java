package com.cafe.proxyservices;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe.DTO.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@FeignClient(name = "USER-SERVICE") // Replace with your actual service URL
public interface UserProxy {

	
	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackmethodforalluser")
    @GetMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE })
    List<User> getAllUsers();
	
	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForGetuserById")
    @GetMapping(value = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    User getUserById(@PathVariable("id") Integer id);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForGetuserByEmailId")
    @GetMapping(value = "/users/{email}", produces = { MediaType.APPLICATION_JSON_VALUE })
    User getUserByEmail(@PathVariable("email") String email);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForuser")
    @PostMapping(value = "/User", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    User addUser(@RequestBody User user);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForUpdateUser")
    @PutMapping(value = "/User", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    User updateUser(@RequestBody User user);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForDeleteuserById")
    @DeleteMapping(value = "/User/{id}")
    void deleteUserById(@PathVariable("id") Integer id);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForuserlogin")
    @PostMapping(value = "/User/login", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    String loginUser(@RequestBody User user);
	
	///=============Fallback method====================/
	
	// Fallback method for getAllUsers
    public default List<User> fallbackmethodforalluser(Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called due to: " + throwable.getMessage());
        return Collections.emptyList();
    }

    // Fallback method for getUserById
    public default User fallbackForGetuserById(Integer id, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for getUserById due to: " + throwable.getMessage());
        return new User(1, "default", "default", "default", "default", "default", "default"); // You can return a default User object or handle it as needed
    }

    // Fallback method for getUserByEmail
    public default User fallbackForGetuserByEmailId(String email, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for getUserByEmail due to: " + throwable.getMessage());
        return new User(1, "default", "default", "default", "default", "default", "default"); // You can return a default User object or handle it as needed
    }

    // Fallback method for addUser
    public default User fallbackForuser(User user, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for addUser due to: " + throwable.getMessage());
        return new User(1, "default", "default", "default", "default", "default", "default");// You can return a default User object or handle it as needed
    }

    // Fallback method for updateUser
    public default User fallbackForUpdateUser(User user, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for updateUser due to: " + throwable.getMessage());
        return new User(1, "default", "default", "default", "default", "default", "default"); // You can return a default User object or handle it as needed
    }

    // Fallback method for deleteUserById
    public default void fallbackForDeleteuserById(Integer id, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for deleteUserById due to: " + throwable.getMessage());
        // You can log and handle the error here, no need to return anything
    }

    // Fallback method for loginUser
    public default String fallbackForuserlogin(User user, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for loginUser due to: " + throwable.getMessage());
        return ""; // You can return a default empty string or handle it as needed
    }

}