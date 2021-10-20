package com.project.foodPartner.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="foodpartnerUsers")
public class fcustomers {
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name = "registeredat")
	private String registeredAt;
	
	@Column(name = "lastlogin")
	private String lastlogin;
	

}
