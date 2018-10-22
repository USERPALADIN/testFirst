package com.finch.demo.controller.api;

import com.finch.demo.config.TokenProvider;
import com.finch.demo.model.AuthToken;
import com.finch.demo.model.LoginUser;
import com.finch.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class RestAuthenticationController {
	
	private final AuthenticationManager authenticationManager;
	
	private final TokenProvider jwtTokenUtil;
	
	private final UserService userService;
	
	@Autowired
	public RestAuthenticationController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, UserService userService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userService = userService;
	}
	
	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
		
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginUser.getUsername(),
						loginUser.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new AuthToken(token));
	}
}
