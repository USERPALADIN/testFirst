package com.finch.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private long id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "password", nullable = false)
	private String password;
	
	
	
	public User(String username, String password, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public User() {
	
	}
	
	//
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "dev_ski",
//			joinColumns = {@JoinColumn(name = "user_id") },
//			inverseJoinColumns = { @JoinColumn(name = "role_id") })
	@EqualsAndHashCode.Exclude
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_id")}, inverseJoinColumns = {
			@JoinColumn(name = "role_id")})
	private List<Role> roles = new ArrayList<>();
	

}