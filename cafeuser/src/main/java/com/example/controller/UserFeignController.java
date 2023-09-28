package com.example.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import com.example.DTO.BookingTable;
import com.example.DTO.Menu;
import com.example.proxyservices.BookTableProxy;
import com.example.proxyservices.Menuproxy;

import java.util.List;

@RestController
@RequestMapping("/user-feign")
public class UserFeignController {

    private static final Logger logger = LoggerFactory.getLogger(UserFeignController.class);

    @Autowired
    BookTableProxy bookTableService;

    @Autowired
    Menuproxy MenuService;

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
}
