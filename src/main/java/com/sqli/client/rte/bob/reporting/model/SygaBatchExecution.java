package com.sqli.client.rte.bob.reporting.model;

import java.util.Date;

public class SygaBatchExecution {
	private long batch_id;
	private Date start_time;
	private int total_offers;
	
	public long getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(long batch_id) {
		this.batch_id = batch_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public int getTotal_offers() {
		return total_offers;
	}
	public void setTotal_offers(int total_offers) {
		this.total_offers = total_offers;
	}
}
