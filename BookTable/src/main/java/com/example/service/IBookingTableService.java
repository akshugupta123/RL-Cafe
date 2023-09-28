package com.example.service;

import java.util.List;

import com.example.domain.BookingTable;

public interface IBookingTableService {

	List<BookingTable> getAllBookings();

	BookingTable getBookingById(Integer id);

	BookingTable addBooking(BookingTable bookingTable);

	BookingTable updateBooking(BookingTable bookingTable);

	void deleteBookingById(Integer id);


}
