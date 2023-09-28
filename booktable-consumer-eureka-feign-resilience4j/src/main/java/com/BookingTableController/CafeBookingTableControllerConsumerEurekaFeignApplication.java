package com.BookingTableController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class CafeBookingTableControllerConsumerEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeBookingTableControllerConsumerEurekaFeignApplication.class, args);
	}

}
