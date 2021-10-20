package com.project.foodPartner.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class FoodUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private fcustomers user;

	public FoodUserDetails(fcustomers user) {
		this.user = user;
		}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.user.getRole()));
		return set;
		}
	
	@Override
	public String getPassword() {
		return user.getPassword();
		}
	
	@Override
	public String getUsername() {
		return user.getUsername();
		}

	@Override
	public boolean isAccountNonExpired() {
		return true;
		}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
		}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
		}
	
	@Override
	public boolean isEnabled() {
		return true;
		}
}
