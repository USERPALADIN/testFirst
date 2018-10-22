package com.finch.demo.service.serviceImpl;

import com.finch.demo.model.Role;
import com.finch.demo.repository.RoleRepository;
import com.finch.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	
	private final RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public Role getByName(String role) {
		return roleRepository.getByName(role);
	}
	
	@Override
	public Role addRole(Role role) {
		return  roleRepository.save(role);
	}
}
