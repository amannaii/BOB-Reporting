package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int position;
	private int quantity;
	private long chronicle_id;
	
	public long getChronicle_id() {
		return chronicle_id;
	}
	public void setChronicle_id(long chronicle_id) {
		this.chronicle_id = chronicle_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
