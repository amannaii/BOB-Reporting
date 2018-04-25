package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ecppoint")
public class EcpPoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long ecpseriesperiod_id;
	
	public long getEcpseriesperiod_id() {
		return ecpseriesperiod_id;
	}
	public void setEcpseriesperiod_id(long ecpseriesperiod_id) {
		this.ecpseriesperiod_id = ecpseriesperiod_id;
	}
}
