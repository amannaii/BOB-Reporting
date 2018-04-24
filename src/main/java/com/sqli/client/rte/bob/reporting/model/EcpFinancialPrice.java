package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class EcpFinancialPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private Double amount;
	private String price_direction;
	private Long ecppoint_id;
	public Long getEcppoint_id() {
		return ecppoint_id;
	}
	public void setEcppoint_id(Long ecppoint_id) {
		this.ecppoint_id = ecppoint_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPrice_direction() {
		return price_direction;
	}
	public void setPrice_direction(String price_direction) {
		this.price_direction = price_direction;
	}
	
	

}
