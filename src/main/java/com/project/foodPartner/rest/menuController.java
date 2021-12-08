package com.project.foodPartner.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodPartner.model.dishes;
import com.project.foodPartner.service.MenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(originPatterns = {"http://localhost:4200","http://192.168.1.102:4200"})

public class menuController {
	
	@Autowired
	private MenuService mservice;
	
	//getTodaysMenu
	@GetMapping("/all")
	public ResponseEntity<List<dishes>> getTodaysMenu(){
		List<dishes> todaysMenuList = mservice.getTodaysMenu();
		return ResponseEntity.ok(todaysMenuList);
	}

}
