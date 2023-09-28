package com.BookingTableController.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.BookingTableController.entity.BookingTableController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
//import com.admin.fallback.AdminServiceFallback;
@FeignClient(name="BookingTableController-service")
//		fallback=AdminServiceFallback.class)
public interface BookingTableControllerServiceProxy {
	@Retry(name="BookingTableController-service")
	@CircuitBreaker(name="BookingTableController-service", fallbackMethod="fallbackMethodGetAllBookingTableController")
	@GetMapping(value = "/tables", produces = (MediaType.APPLICATION_JSON_VALUE))
	public List<BookingTableController> getAllBookingTableController() ;
	@Retry(name="BookingTableController-service")
	@CircuitBreaker(name="BookingTableController-service", fallbackMethod="fallbackMethodGetBookingTableControllerById")
	@GetMapping(value = "/tables/{id}", produces = (MediaType.APPLICATION_JSON_VALUE))
	public BookingTableController getBookingTableControllerById(@PathVariable("id") Integer id) ;
		
	
	public default List<BookingTableController> fallbackMethodGetAllBookingTableController(Throwable cause) {
		System.out.println("Exception raised with message:===> " + cause.getMessage());
		return new ArrayList<BookingTableController>();
	}


	public default  BookingTableController  fallbackMethodGetBookingTableControllerById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message:===> " + cause.getMessage());
		return new BookingTableController(id,"23-09-2023","21:00","AC",9,"Available","confirmed");
		
	}

	
}
