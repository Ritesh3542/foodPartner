
package com.project.foodPartner.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodPartner.model.tables;

public interface tablesrepo extends JpaRepository<tables,String> {
	public tables findByTableid(String tableId);
}
