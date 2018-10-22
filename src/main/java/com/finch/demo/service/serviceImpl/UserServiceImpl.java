package com.finch.demo.service.serviceImpl;


import com.finch.demo.model.User;
import com.finch.demo.repository.UserRepository;
import com.finch.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	private final UserRepository userRepository;
	
	private final BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bcryptEncoder) {
		this.userRepository = userRepository;
		this.bcryptEncoder = bcryptEncoder;
	}
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findFirstByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach( role-> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}
	
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User addUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User getByName(String name) {
		return userRepository.findFirstByUsername(name);
	}
	
	@Override
	public Optional<User> getUserById(long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User updateUser(User user) {
		return  userRepository.save(user);
	}
	
	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}
	
}
