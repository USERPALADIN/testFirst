package com.finch.demo.repository;

import com.finch.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
		User findFirstByUsername(String name);
}
