package com.project.foodPartner.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodPartner.model.dishes;

public interface dishesrepo extends JpaRepository<dishes,String>{

	List<dishes> findByDstatustoday(Integer dstatustoday);
}
