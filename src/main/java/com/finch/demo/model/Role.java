package com.finch.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	
	public Role(String name) {
		this.name = name;
	}
	
	public Role() {
	
	}
	
	public String getName() {
		return name;
	}
	
}