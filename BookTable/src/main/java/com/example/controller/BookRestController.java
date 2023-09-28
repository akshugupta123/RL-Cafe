package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.domain.BookingTable;
import com.example.service.IBookingTableService;

@RestController
@Scope("request")
public class BookRestController {

    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    @Qualifier("booktableService")
    private IBookingTableService booktableService;

    @GetMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<BookingTable> getAllBookings() {
        logger.debug("Fetching all bookings...");
        List<BookingTable> bookings = booktableService.getAllBookings();
        logger.debug("Fetched {} bookings.", bookings.size());
        return bookings;
    }

    @GetMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public BookingTable getBookingById(@PathVariable("id") Integer id) {
        logger.debug("Fetching booking with ID: {}", id);
        BookingTable booking = booktableService.getBookingById(id);
        if (booking != null) {
            logger.debug("Fetched booking with ID {}: {}", id, booking);
        } else {
            logger.debug("Booking with ID {} not found.", id);
        }
        return booking;
    }

    @PostMapping(value = "/tables", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookingTable addBooking(@RequestBody BookingTable bookingTable) {
        logger.debug("Adding a new booking: {}", bookingTable);
        BookingTable addedBooking = booktableService.addBooking(bookingTable);
        logger.debug("Added booking with ID {}: {}", addedBooking.getId(), addedBooking);
        return addedBooking;
    }

    @PutMapping(value = "/tables/{id}", produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.OK)
    public BookingTable updateBooking(@PathVariable("id") Integer id, @RequestBody BookingTable bookingTable) {
        logger.debug("Updating booking with ID: {}", id);
        // Implement update logic here
        // Replace the following line with your actual logic
        return null;
    }

    @DeleteMapping(value = "/tables/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable("id") Integer id) {
        logger.debug("Deleting booking with ID: {}", id);
        // Implement delete logic here
    }
}
