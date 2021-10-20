package com.project.foodPartner.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodPartner.model.orders;

public interface ordersrepo extends JpaRepository<orders,String> {
	
	orders findByOrderId(String orderId);
	List<orders> findByCustId(String custId);

}
