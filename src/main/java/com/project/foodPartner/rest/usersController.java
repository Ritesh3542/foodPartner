package com.project.foodPartner.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.service.fooduserServices;

@RestController
@RequestMapping("/foodUser")
public class usersController {
	
	@Autowired
	private fooduserServices fuservices;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//create user
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody fcustomers userdetails){
		userdetails.setPassword(this.bCryptPasswordEncoder.encode(userdetails.getPassword()));
		String body = fuservices.createUser(userdetails);
		return ResponseEntity.ok(body);
	}
	
/**	//login
	@PostMapping("/loginCheck")
	public ResponseEntity<String> loginUser(@RequestBody userdto userCredentials){
		fcustomers userObj = fuservices.loginUser(userCredentials.getUsername(),userCredentials.getPassword());
		String body = "logged in with username "+userObj.getUsername();
		return ResponseEntity.ok(body);
	}**/
	
}
