package com.project.foodPartner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodPartner.model.dishes;
import com.project.foodPartner.repo.dishesrepo;
import com.project.foodPartner.service.MenuService;

@Service
public class menuServicesimpl implements MenuService {


	@Autowired
	private dishesrepo repo;
	
	public List<dishes> getTodaysMenu() {
		Integer status = 1;
		List<dishes> todaysMenu = repo.findByDstatustoday(status);
		return todaysMenu;
	}

}
