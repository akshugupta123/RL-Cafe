package com.example.services;

import java.util.List;


import com.example.entity.User;

public interface IUserService {

	
	
	
User addUser(User user);
	
	

	List<User> getAllUsers();

	User getUserById(Integer id);



	User getUserByEmail(String email);



	User updateUser(User user);



	void deleteUserById(Integer id);
}
