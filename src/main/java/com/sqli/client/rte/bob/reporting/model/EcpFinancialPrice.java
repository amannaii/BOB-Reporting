package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ecpfinancialprice")
public class EcpFinancialPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long ecppoint_id;
	public long getEcppoint_id() {
		return ecppoint_id;
	}
	public void setEcppoint_id(long ecppoint_id) {
		this.ecppoint_id = ecppoint_id;
	}
}
