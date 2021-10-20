package com.project.foodPartner.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.repo.foodusersrepo;
import com.project.foodPartner.service.fooduserServices;

@Service
public class fooduserServicesimpl implements fooduserServices {

	@Autowired
	private foodusersrepo repo;
	
	public String createUser(fcustomers userDetails) {

		userDetails.setRegisteredAt(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		userDetails = repo.save(userDetails);
		String username =  userDetails.getUsername();
		return username+"saved";
	}
/**
	public fcustomers loginUser(String username, String password) {
		fcustomers userObj = repo.findByUsernameAndPassword(username,password);
		userObj.setLastlogin(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		repo.save(userObj);
		return userObj;
	}
**/
}
