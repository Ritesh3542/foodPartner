package com.project.foodPartner.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodPartner.model.fcustomers;

public interface foodusersrepo extends JpaRepository<fcustomers,String> {
	public fcustomers findByUsername(String username);
}
