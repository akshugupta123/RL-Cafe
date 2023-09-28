package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.UserRepository.UserRepository;
import com.example.entity.User;





@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CafeuserApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CafeuserApplication.class, args);
	}

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
	
	userRepository.save(new User(1,"user","user@gmail.com","12345","A Tale of Two Cities","user","user"));

	System.out.println(userRepository.findAll());
	}

}
