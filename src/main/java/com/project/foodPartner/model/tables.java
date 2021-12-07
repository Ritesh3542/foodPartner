package com.project.foodPartner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tables")
public class tables {
	@Id
	@Column(name="tableid")
	private String tableid;
	@Column(name="custid")
	private String custId;
	@Column(name="tablestaus")
	private Integer tablestatus;

}
