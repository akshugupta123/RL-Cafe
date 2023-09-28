package com.cafe.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.DTO.BookingTable;
import com.cafe.DTO.Menu;
import com.cafe.DTO.User;
import com.cafe.proxyservices.BookTableProxy;
import com.cafe.proxyservices.Menuproxy;
import com.cafe.proxyservices.UserProxy;







@RestController
@RequestMapping("/admin-feign")
public class AdminFeignController {
	
	
	@Autowired
	BookTableProxy bookTableService;
	@Autowired
	UserProxy UserService;
	@Autowired
	Menuproxy MenuService;
	
	  private static final Logger logger = LoggerFactory.getLogger(AdminFeignController.class);
//users part
	// Users part
	    @GetMapping(value = "/users")
	    public List<User> getAllUsers() {
	        logger.debug("Fetching all users...");
	        List<User> users = UserService.getAllUsers();
	        logger.debug("Fetched {} users.", users.size());
	        return users;
	    }
	    @GetMapping(value = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	    User getUserById(@PathVariable("id") Integer id) {
	    	 logger.debug("Fetching all users...");
	    	User user = UserService.getUserById(id);
	    	return user;
	    }
	   
	    @GetMapping(value = "/users/{email}",produces = { MediaType.APPLICATION_JSON_VALUE })
	    User getUserByEmail(@PathVariable("email")String email) {
	    	 logger.debug("Fetching all users...");
	    	User user = UserService.getUserByEmail(email);
	    	return user;
	    }
	
	    
	    @DeleteMapping(value = "/User/{id}")
	    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	    public void deleteUserById(@PathVariable("id") Integer id) {
	        logger.debug("Deleting user with ID: {}", id);
	        UserService.deleteUserById(id);
	        logger.debug("User with ID {} deleted successfully.", id);
	    }

	    // Menu part
	    @GetMapping(value = "/menus")
	    public List<Menu> getAllMenus() {
	        logger.debug("Fetching all menus...");
	        List<Menu> menus = MenuService.getAllMenus();
	        logger.debug("Fetched {} menus.", menus.size());
	        return menus;
	    }

	    @GetMapping(value = "/menus/{id}")
	    public Menu getMenuById(@PathVariable("id") Long id) {
	        logger.debug("Fetching menu with ID: {}", id);
	        Menu menu = MenuService.getMenuById(id);
	        logger.debug("Fetched menu with ID {}: {}", id, menu);
	        return menu;
	    }

	    @PostMapping(value = "/menu", produces = { MediaType.APPLICATION_JSON_VALUE },
	            consumes = { MediaType.APPLICATION_JSON_VALUE })
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public Menu addMenu(@RequestBody Menu menu) {
	        logger.debug("Adding a new menu: {}", menu);
	        Menu addedMenu = MenuService.addMenu(menu);
	        logger.debug("Added menu with ID {}: {}", addedMenu.getId(), addedMenu);
	        return addedMenu;
	    }

	    @PutMapping(value = "/menu", produces = { MediaType.APPLICATION_JSON_VALUE },
	            consumes = { MediaType.APPLICATION_JSON_VALUE })
	    @ResponseStatus(code = HttpStatus.OK)
	    public Menu updateMenu(@RequestBody Menu menu) {
	        logger.debug("Updating menu with ID: {}", menu.getId());
	        Menu updatedMenu = MenuService.updateMenu(menu);
	        logger.debug("Updated menu with ID {}: {}", updatedMenu.getId(), updatedMenu);
	        return updatedMenu;
	    }

	    @DeleteMapping(value = "/menu/{id}")
	    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	    public void deleteMenuById(@PathVariable("id") Integer id) {
	        logger.debug("Deleting menu with ID: {}", id);
	        MenuService.deleteMenuById(id);
	        logger.debug("Menu with ID {} deleted successfully.", id);
	    }

	    // Book table part
	    @GetMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE })
	    public List<BookingTable> getAllBookings() {
	        logger.debug("Fetching all bookings...");
	        List<BookingTable> bookings = bookTableService.getAllBookings();
	        logger.debug("Fetched {} bookings.", bookings.size());
	        return bookings;
	    }

	    @GetMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	    public BookingTable getBookingById(@PathVariable("id") Integer id) {
	        logger.debug("Fetching booking with ID: {}", id);
	        BookingTable booking = bookTableService.getBookingById(id);
	        logger.debug("Fetched booking with ID {}: {}", id, booking);
	        return booking;
	    }

	    @PostMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE },
	            consumes = { MediaType.APPLICATION_JSON_VALUE })
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public BookingTable addBooking(@RequestBody BookingTable bookingTable) {
	        logger.debug("Adding a new booking: {}", bookingTable);
	        BookingTable addedBooking = bookTableService.createBooking(bookingTable);
	        logger.debug("Added booking with ID {}: {}", addedBooking.getId(), addedBooking);
	        return addedBooking;
	    }

	    @PutMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE },
	            consumes = { MediaType.APPLICATION_JSON_VALUE })
	    @ResponseStatus(code = HttpStatus.OK)
	    public BookingTable updateBooking(@PathVariable("id") Integer id, @RequestBody BookingTable bookingTable) {
	        logger.debug("Updating booking with ID: {}", id);
	        BookingTable updatedBooking = bookTableService.updateBooking(id, bookingTable);
	        logger.debug("Updated booking with ID {}: {}", updatedBooking.getId(), updatedBooking);
	        return updatedBooking;
	    }

	    @DeleteMapping(value = "/tables/{id}")
	    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	    public void deleteBooking(@PathVariable("id") Integer id) {
	        logger.debug("Deleting booking with ID: {}", id);
	        bookTableService.deleteBooking(id);
	        logger.debug("Booking with ID {} deleted successfully.", id);
	    }
	    
	  
}