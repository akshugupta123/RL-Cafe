package com.cafe.proxyservices;


import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cafe.DTO.BookingTable;
import com.cafe.DTO.Menu;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;





@FeignClient(name = "CAFEMENU-SERVICE") // Replace with your actual service URL
public interface Menuproxy {

	
	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackmethodforallmenu")
    @GetMapping(value = "/menus", produces = { MediaType.APPLICATION_JSON_VALUE })
    List<Menu> getAllMenus();

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForGetmenuById")
    @GetMapping(value = "/menus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    Menu getMenuById(@PathVariable("id") Long id);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackFormenu")
    @PostMapping(value = "/menu", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    Menu addMenu(@RequestBody Menu menu);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForUpdateMenu")
    @PutMapping(value = "/menu", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    Menu updateMenu(@RequestBody Menu menu);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForDeleteMenuById")
    @DeleteMapping(value = "/menu/{id}")
    void deleteMenuById(@PathVariable("id") Integer id);

///=============Fallback method====================/

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

    // Fallback method for addMenu
    public default Menu fallbackFormenu(Menu menu, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for addMenu due to: " + throwable.getMessage());
        return new Menu(); // You can return a default Menu object or handle it as needed
    }

    // Fallback method for updateMenu
    public default Menu fallbackForUpdateMenu(Menu menu, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for updateMenu due to: " + throwable.getMessage());
        return new Menu(); // You can return a default Menu object or handle it as needed
    }

    // Fallback method for deleteMenuById
    public default void fallbackForDeleteMenuById(Integer id, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for deleteMenuById due to: " + throwable.getMessage());
        // You can log and handle the error here, no need to return anything
    }
}