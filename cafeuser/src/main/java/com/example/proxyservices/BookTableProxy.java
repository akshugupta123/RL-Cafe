package com.example.proxyservices;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.Collections;
import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.DTO.BookingTable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;





@FeignClient("BOOKTABLE-SERVICE")
public interface BookTableProxy {

	
	@Retry(name = "user-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackmethodforallBook")
    @GetMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE })
    List<BookingTable> getAllBookings();

	@Retry(name = "user-feign-retry")
	@CircuitBreaker(name = "admin-feign-cb", fallbackMethod = "fallbackForGettableById")
    @GetMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    BookingTable getBookingById(@PathVariable("id") Integer id);

//  /=============Fallback method====================/
	
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

  

	
}