package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.domain.BookingTable;
import com.example.repository.BookTableRepository;

@EnableEurekaClient
@SpringBootApplication
public class BookTableApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookTableApplication.class, args);
	}
	
	

	@Autowired
	@Qualifier("booktableRepository")
	private BookTableRepository booktableRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		booktableRepository.save(new BookingTable(1,"28-09-2021","22:00","AC",12,"Availble","confirmed",2));
		booktableRepository.save(new BookingTable(2,"22-09-2021","14:00","AC",12,"Availble","confirmed",1));
     	booktableRepository.save(new BookingTable(3,"25-09-2021","15:00","NON-AC",12,"Availble","confirmed",3));
//		booktableRepository.save(new BookingTable(4,"21-09-2021","18:00","AC",12,"Availble","confirmed",7));
//		booktableRepository.save(new BookingTable(5,"18-09-2021","20:00","NON-AC",12,"Availble","confirmed",5));
//		booktableRepository.save(new BookingTable(6,"15-09-2021","16:00","AC",12,"Availble","confirmed",4));
//		booktableRepository.save(new BookingTable(7,"12-09-2021","19:00","AC",12,"Availble","confirmed",3));
//		booktableRepository.save(new BookingTable(8,"21-09-2021","21:00","NON-AC",12,"Availble","confirmed",1));
		
		//	bookRepository.save(new Book(2,"The Moon Stone", "34534",2569,19869,"c.Dickens"));
//    	bookRepository.save(new Book(3,"Uncle Bernac", "44534-865-988",200,1897,"A.C.Doyle"));
//		bookRepository.save(new Book(4,"A Changed Man", "335-87789-9834",150,1913,"T.Hardly"));
//		bookRepository.save(new Book(5,"All the Gold Stars", "789-988-63534",143,2021,"Rainesford Stauffer"));
System.out.println(booktableRepository.findAll());
	}

}
