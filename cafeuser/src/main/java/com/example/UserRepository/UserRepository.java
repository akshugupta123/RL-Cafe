package com.example.UserRepository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.entity.User;

@Repository(value = "userRepository")
@Scope("singleton")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User getByEmail(String email);
}
