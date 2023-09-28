package com.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cafe.entity.Admin;
import com.cafe.repository.AdminRepository;
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class CafeadminApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CafeadminApplication.class, args);
	}
	@Autowired
	@Qualifier("adminRepository")
	private AdminRepository adminRepository;
	@Override
	public void run(String... args) throws Exception {
	
	adminRepository.save(new Admin(1,"admin","admin123@gmail.com","8096956409","A Tale of Two Cities","admin","admin"));
	adminRepository.save(new Admin(2,"admin2","admin@gmail.com","8096956409","A Tale of Two Cities","admin2","admin2"));

	System.out.println(adminRepository.findAll());
	}

}
