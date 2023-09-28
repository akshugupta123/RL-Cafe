package com.cafe.proxyservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cafe.DTO.BookingTable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@FeignClient("BOOKTABLE-SERVICE")
public interface BookTableProxy {
	
	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackmethodforallBook")
    @GetMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE })
    List<BookingTable> getAllBookings();

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForGettableById")
    @GetMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    BookingTable getBookingById(@PathVariable("id") Integer id);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForTable")
    @PostMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    BookingTable createBooking(@RequestBody BookingTable booking);
	
	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForUpdateTable")
    @PutMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    BookingTable updateBooking(@PathVariable("id") Integer id, @RequestBody BookingTable booking);

	@Retry(name = "admin-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForDeleteTableById")
    @DeleteMapping(value = "/tables/{id}")
    void deleteBooking(@PathVariable("id") Integer id);
    
//    /=============Fallback method====================/
	
    public default List<BookingTable> fallbackmethodforallBook(Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called due to: " + throwable.getMessage());
        return Collections.emptyList();
    }

 // Fallback method for getBookingById
    public default BookingTable fallbackForGettableById(Integer id, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for getBookingById due to: " + throwable.getMessage());
        return new BookingTable(); // You can return a default or empty BookingTable object
    }

    // Fallback method for createBooking
     public default BookingTable fallbackForTable(BookingTable booking, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for createBooking due to: " + throwable.getMessage());
        return new BookingTable(); // You can return a default or empty BookingTable object
    }

    // Fallback method for updateBooking
    public default BookingTable fallbackForUpdateTable(Integer id, BookingTable booking, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for updateBooking due to: " + throwable.getMessage());
        return new BookingTable(); // You can return a default or empty BookingTable object
    }

    // Fallback method for deleteBooking
   public  default void fallbackForDeleteTableById(Integer id, Throwable throwable) {
        // Log the exception or error, if needed
        System.err.println("Fallback called for deleteBooking due to: " + throwable.getMessage());
    }
	
}