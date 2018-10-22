package com.finch.demo.service;

import com.finch.demo.model.Role;

public interface RoleService {
	
	Role getByName(String role);
	
	Role addRole(Role role);
}
