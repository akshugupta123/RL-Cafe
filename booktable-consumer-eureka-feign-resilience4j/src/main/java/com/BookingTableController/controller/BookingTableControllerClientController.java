package com.BookingTableController.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BookingTableController.domain.BookingTableController;
import com.BookingTableController.proxy.BookingTableControllerServiceProxy;

@RestController
@Scope("request")
public class BookingTableControllerClientController<BookingTableControllerServiceProxy> {
	
	@Autowired
	private BookingTableControllerServiceProxy BookingTableControllerServiceProxy;

	@GetMapping("/get-tables/{id}")
	public BookingTableControllerClientController getBookingTableControllerById(@PathVariable("id") int id) {
		BookingTableControllerClientController BookingTableController=((BookingTableControllerClientController) BookingTableControllerServiceProxy).getBookingTableControllerById(id);
		return BookingTableController;
	}

	@GetMapping("/get-tables")
	public List<BookingTableControllerClientController> getAllBookingTableController() {
		List<BookingTableControllerClientController> BookingTableController=((BookingTableControllerClientController) BookingTableControllerServiceProxy).getAllBookingTableController();
		return BookingTableController;
	}
	
}
