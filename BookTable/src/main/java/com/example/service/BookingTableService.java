package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BookingTable;
import com.example.repository.BookTableRepository;

@Service("booktableService")
@Scope("singleton")
@Transactional
public class BookingTableService implements IBookingTableService {

    @Autowired
    @Qualifier("booktableRepository")
    private BookTableRepository booktableRepository;

    @Override
    public List<BookingTable> getAllBookings() {
        return booktableRepository.findAll();
    }

    @Override
    public BookingTable getBookingById(Integer id) {
        return booktableRepository.findById(id).orElse(null);
    }

    @Override
    public BookingTable addBooking(BookingTable bookingTable) {
        return booktableRepository.save(bookingTable);
    }

    @Override
    public BookingTable updateBooking(BookingTable bookingTable) {
        return booktableRepository.save(bookingTable);
    }

    @Override
    public void deleteBookingById(Integer id) {
        booktableRepository.deleteById(id);
    }
}
