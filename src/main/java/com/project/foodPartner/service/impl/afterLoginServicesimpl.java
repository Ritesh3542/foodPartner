package com.project.foodPartner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.model.orders;
import com.project.foodPartner.model.ratingsandreviews;
import com.project.foodPartner.model.tables;
import com.project.foodPartner.repo.foodusersrepo;
import com.project.foodPartner.repo.ordersrepo;
import com.project.foodPartner.repo.ratingReviewrepo;
import com.project.foodPartner.repo.tablesrepo;
import com.project.foodPartner.service.afterLoginService;

@Service
public class afterLoginServicesimpl implements afterLoginService {

	@Autowired
	private foodusersrepo frepo;
	
	@Autowired
	private ordersrepo orepo;
	
	@Autowired
	private ratingReviewrepo rrepo;
	
	@Autowired
	private tablesrepo trepo;
	
	public String updateUser(fcustomers userDetails) {
		fcustomers userObj = frepo.save(userDetails);
		String name = userObj.getName();
		String mString = name+" your account details updated";
		return mString;
	}

	public fcustomers getOneUser(String username) {
		fcustomers userObj = frepo.findByUsername(username);
		return userObj;
	}

	public String placeorderDetails(orders orderdetails) {
		orepo.save(orderdetails);
		String message = "order placed";
		return message;
	}

	public orders getOrderdetails(String orderid) {
		orders orderObj = orepo.findByOrderId(orderid);
		return orderObj;
	}

	public List<orders> getAllOrders(String custid) {
		List<orders> orderListObj = orepo.findByCustId(custid);
		return orderListObj;
	}

	public String submitFeedback(ratingsandreviews custFeedback) {
		rrepo.save(custFeedback);
		String message = "Thankyou for feedback";
		return message;
	}


	public String updateTableRecord(tables tabObj) {
		String messageString = "UPDATED table detail";
		trepo.save(tabObj);
		return messageString;
	}

	public tables getTableDetails(String tableId) {
		tables tabObj = trepo.findByTableid(tableId);
		return tabObj;
	}

	@Override
	public List<tables> getAllTables() {
		List<tables> tabObjs = trepo.findAll();
		return tabObjs;
	}

}
