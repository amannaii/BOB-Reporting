package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ecptimeseries")
public class EcpTimeSeries {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long ecpmarketdocument_id;
	
	public long getEcpmarketdocument_id() {
		return ecpmarketdocument_id;
	}
	public void setEcpmarketdocument_id(long ecpmarketdocument_id) {
		this.ecpmarketdocument_id = ecpmarketdocument_id;
	}
}
