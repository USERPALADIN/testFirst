package com.finch.demo.service;

import com.finch.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
	List<User> getAllUsers();
	
	User addUser(User user);
	
	User getByName(String name);
	
	Optional<User> getUserById(long id);
	
	User updateUser(User user);
	
	void deleteUserById(long id);
}
