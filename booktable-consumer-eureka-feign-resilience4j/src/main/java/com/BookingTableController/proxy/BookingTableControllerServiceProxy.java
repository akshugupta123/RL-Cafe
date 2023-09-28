package com.BookingTableController.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.BookingTableController.domain.BookingTableController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
//import com.mphasis.fallback.BookServiceFallback;
@FeignClient(name="BookingTableController-service")
//		fallback=BookServiceFallback.class)
public interface BookingTableControllerServiceProxy {
	@Retry(name="BookingTableController-service")
	@CircuitBreaker(name="BookingTableController-service", fallbackMethod="fallbackMethodGetAllBooks")
	@GetMapping(value = "/tables", produces = (MediaType.APPLICATION_JSON_VALUE))
	public List<BookingTableController> getAllMenus() ;
	@Retry(name="BookingTableController-service")
	@CircuitBreaker(name="BookingTableController-service", fallbackMethod="fallbackMethodGetBookById")
	@GetMapping(value = "/tables/{id}", produces = (MediaType.APPLICATION_JSON_VALUE))
	public BookingTableController getBookById(@PathVariable("id") Integer id) ;
		
	
	public default List<BookingTableController> fallbackMethodGetAllBookingTableController(Throwable cause) {
		System.out.println("Exception raised with message:===> " + cause.getMessage());
		return new ArrayList<BookingTableController>();
	}


	public default  BookingTableController  fallbackMethodGetMenuById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message:===> " + cause.getMessage());
		return new BookingTableController(10,"24-09-2023","22:00","AC",9,"Available","confirmed");
		
	}
	public BookingTableController getBookingTabkeById(int id);

	
}
