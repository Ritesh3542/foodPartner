package com.project.foodPartner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ratingsAndReviews")
public class ratingsandreviews {
	
	@Id
	@GeneratedValue
	@Column(name="rid")
	private Integer rid;
	@Column(name="rstatus")
	private Integer rstatus;
	@Column(name="customerid")
	private String custId;
	@Column(name="orderid")
	private String orderId;
	@Column(name="dishid")
	private String dishId;
	@Column(name="dishrating")
	private float ratings;
	@Column(name="dishreview")
	private String reviews;

}
