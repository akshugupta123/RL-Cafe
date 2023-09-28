package com.example.repository;

import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.BookingTable;

@Repository(value = "booktableRepository")
@Scope("singleton")
public interface BookTableRepository extends JpaRepository<BookingTable, Integer> {

	//Optional<Book> findBookByYear(int year);

//	Optional<Book> getBookByYear(int year);
//
//	Book findByTitle(String title);

	//Optional<Book> getBookPublisher(String publisher);
//	Optional<Book> getBookByPublisher(String publisher);

	
}
