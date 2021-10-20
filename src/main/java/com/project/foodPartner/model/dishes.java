package com.project.foodPartner.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dishes")
public class dishes {
	
	@Id
	@GeneratedValue
	@Column(name="dishid")
	private String dId;
	
	@Column(name="dishname")
	private String dname;
	
	@Column(name="dishphoto")
	private String dphoto;
	
	@Column(name="dishprice")
	private String dprice;
	
	@Column(name="dishratings")
	private Float drating;
	
	@Column(name="dishreviews")
	private String[] dreview;
	
	@Column(name="dishvegnonveg")
	private Integer dvn;
	
	@Column(name="dishimages")
	private String[] dimages;
	
	@Column(name="dishstatustoday")
	private Integer dstatustoday;
	
	@Column(name="dishtype")
	private String type;
	

}
