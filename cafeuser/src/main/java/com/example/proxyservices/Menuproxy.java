package com.example.proxyservices;



import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.DTO.Menu;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;







@FeignClient(name = "CAFEMENU-SERVICE") // Replace with your actual service URL
public interface Menuproxy {

	
	@Retry(name = "user-feign-retry")
	@CircuitBreaker(name = "user-feign-cb", fallbackMethod = "fallbackmethodforallmenu")
    @GetMapping(value = "/menus", produces = { MediaType.APPLICATION_JSON_VALUE })
    List<Menu> getAllMenus();

	
	@Retry(name = "user-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForGetmenuById")
    @GetMapping(value = "/menus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    Menu getMenuById(@PathVariable("id") Long id);

   
	//=============Fallback method====================/

		// Fallback method for getAllMenus
	    public default List<Menu> fallbackmethodforallmenu(Throwable throwable) {
	        // Log the exception or error, if needed
	        System.err.println("Fallback called due to: " + throwable.getMessage());
	        return Collections.emptyList();
	    }

	    // Fallback method for getMenuById
	    public default Menu fallbackForGetmenuById(Long id, Throwable throwable) {
	        // Log the exception or error, if needed
	        System.err.println("Fallback called for getMenuById due to: " + throwable.getMessage());
	        return new Menu(); // You can return a default Menu object or handle it as needed
	    }

    
}
