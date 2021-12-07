package com.project.foodPartner.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodPartner.model.FoodUserDetails;
import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.model.tables;
import com.project.foodPartner.service.afterLoginService;

@RestController
@RequestMapping("/admin")
//@CrossOrigin(origins = "")
@CrossOrigin(originPatterns = {"http://localhost:62299","http://192.168.1.102:62299"})
public class adminController {

	@Autowired
	private afterLoginService alService;

	@GetMapping("/user")
	public ResponseEntity<fcustomers> getOneUser(@AuthenticationPrincipal FoodUserDetails user){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		user = (FoodUserDetails) auth.getPrincipal();
		fcustomers objFcustomers = alService.getOneUser(user.getUsername());
		return ResponseEntity.ok(objFcustomers);
	}
	
	@GetMapping("/table/{tableId}")
	public ResponseEntity<tables> getOneTableDetail(@PathVariable String tableId){
		tables tabObj = alService.getTableDetails(tableId);
		return ResponseEntity.ok(tabObj);
	}
	
	@GetMapping("/tables")
	public ResponseEntity<List<tables>> getAllTables(){
		List<tables> tablesObjs = alService.getAllTables();
		return ResponseEntity.ok(tablesObjs);
	}
	

}
