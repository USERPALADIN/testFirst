package com.finch.demo.repository;

import com.finch.demo.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role getByName(String role);
}
