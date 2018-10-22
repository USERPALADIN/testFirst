package com.finch.demo.controller.api;

import com.finch.demo.model.User;
import com.finch.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestUserController {
	
	private final UserService userService;
	
	@Autowired
	public RestUserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
	
}