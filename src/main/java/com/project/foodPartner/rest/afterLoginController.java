package com.project.foodPartner.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodPartner.model.FoodUserDetails;
import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.model.orders;
import com.project.foodPartner.model.ratingsandreviews;
import com.project.foodPartner.model.tables;
import com.project.foodPartner.service.afterLoginService;

@RestController
@RequestMapping("/check")
//@CrossOrigin(origins = "")
@CrossOrigin(originPatterns = {"http://localhost:62299","http://192.168.1.102:4200"})
public class afterLoginController {
	
	@Autowired
	private afterLoginService alService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//login
	@GetMapping("/login")
	public ResponseEntity<String> loginCheck(@AuthenticationPrincipal FoodUserDetails user){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		user = (FoodUserDetails) auth.getPrincipal();
		return ResponseEntity.ok(user.getUsername());
	}
	
	//updateUser
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody fcustomers newUserDetails){
		newUserDetails.setPassword(this.bCryptPasswordEncoder.encode(newUserDetails.getPassword()));
		String body = alService.updateUser(newUserDetails);
		return ResponseEntity.ok(body);
	}
	//getOneUser details
	@GetMapping("/user")
	public ResponseEntity<fcustomers> getOneUser(@AuthenticationPrincipal FoodUserDetails user){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		user = (FoodUserDetails) auth.getPrincipal();
		fcustomers objFcustomers = alService.getOneUser(user.getUsername());
		return ResponseEntity.ok(objFcustomers);
	}
	//placeOrderDetails
	@PostMapping("/orderplaced?")
	public ResponseEntity<String> placeOrderDetails(@RequestBody orders orderdetails){
		String body = alService.placeorderDetails(orderdetails);
		return ResponseEntity.ok(body);
	}
	//getOrderDetails
	@GetMapping("/order/orderdetails/:{orderid}")
	public ResponseEntity<orders> getOrderDetails(@PathVariable String orderid){
		orders orderobj = alService.getOrderdetails(orderid);
		return ResponseEntity.ok(orderobj);
	}
	//getAllOrders
	@GetMapping("/allorders/:{custid}")
	public ResponseEntity<List<orders>> getAllOrders(@PathVariable String custid){
		List<orders> orderobjs  = alService.getAllOrders(custid);
		return ResponseEntity.ok(orderobjs);
	}
	//submitFeedback
	@PostMapping("/submitfeedback")
	public ResponseEntity<String> submitFeedback(@RequestBody ratingsandreviews feedbackDetails){
		String body = alService.submitFeedback(feedbackDetails);
		return ResponseEntity.ok(body);
	}
	
	@PostMapping("/updateTable")
	public ResponseEntity<String> updateTablesRecord(@RequestBody tables tabObj){
		String body = alService.updateTableRecord(tabObj);
		return ResponseEntity.ok(body);
	}
	

}
