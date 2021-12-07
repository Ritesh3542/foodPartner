package com.project.foodPartner.service;

import java.util.List;

import com.project.foodPartner.model.fcustomers;
import com.project.foodPartner.model.orders;
import com.project.foodPartner.model.ratingsandreviews;
import com.project.foodPartner.model.tables;

public interface afterLoginService {

	String updateUser(fcustomers userDetails);
	fcustomers getOneUser(String username);
	String placeorderDetails(orders orderdetails);
	orders getOrderdetails(String orderid);
	List<orders> getAllOrders(String custid);
	String submitFeedback(ratingsandreviews custFeedback);
	String updateTableRecord(tables tableObj);
	tables getTableDetails(String tableId);
	List<tables> getAllTables();
}
