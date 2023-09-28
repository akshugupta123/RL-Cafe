package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.UserRepository.UserRepository;
import com.example.entity.User;





@Service(value = "userService")
@Scope("singleton")
@Transactional
public class UserServices implements IUserService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User>getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.getByEmail(email);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
		
	}

	


}
