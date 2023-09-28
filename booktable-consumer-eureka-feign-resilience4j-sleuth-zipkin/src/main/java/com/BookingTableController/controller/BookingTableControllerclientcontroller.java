package com.BookingTableController.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BookingTableController.entity.BookingTableController;
import com.BookingTableController.proxy.BookingTableControllerServiceProxy;

 

@RestController
@Scope("request")
public class BookingTableControllerclientcontroller {
	
	@Autowired
	private BookingTableControllerServiceProxy BookingTableControllerServiceProxy;

	private Logger log =LoggerFactory.getLogger(BookingTableControllerclientcontroller.class);
	@GetMapping("/get-tables/{id}")
	public BookingTableController getBookingTableControllerById(@PathVariable("id") int id) {
		log.debug("In getBookingTableControllerById with ID: " + id);
		
		BookingTableController BookingTableController=BookingTableControllerServiceProxy.getBookingTableControllerById(id);
		log.debug("In getBookingTableControllerById with return value BookingTableController: " + BookingTableController);

		return BookingTableController;
	}

	@GetMapping("/get-tables")
	public List<BookingTableController> getAllBookingTableController() {
		List<BookingTableController> BookingTableController=BookingTableControllerServiceProxy.getAllBookingTableController();
		log.debug("In getAllBookingTableController with return value BookingTableController: " + BookingTableController);

		return BookingTableController;
	}
	
}
