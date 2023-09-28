package com.BookingTableController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class BookingTableControllerConsumerEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingTableControllerConsumerEurekaFeignApplication.class, args);
	}
	@Bean
	public Sampler getSampler() {
		
		//return Sampler.create(0.5f);
		return Sampler.ALWAYS_SAMPLE;
	}
}
