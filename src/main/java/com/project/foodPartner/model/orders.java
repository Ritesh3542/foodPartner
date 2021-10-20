package com.project.foodPartner.model;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class orders {

	@Id
	@GeneratedValue
	@Column(name="orderid")
	private String orderId;
	
	@Column(name="ordert")
	private Timestamp orderat;
	
	@Column(name="tableid")
	private String tableId;
	
	@Column(name="custid")
	private String custId;
	
	@Column(name="orderstatus")
	private Integer orderstatus;
	
	@Column(name="odishid")
	private String[] odishid;
	
	@Column(name="dishquantity")
	private Integer[] quantity;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="dishcustomization")
	private String[] dishcustomizationList;

	
}
