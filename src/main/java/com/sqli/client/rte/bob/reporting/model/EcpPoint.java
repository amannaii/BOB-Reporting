package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EcpPoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private java.math.BigDecimal activation_price_amount;
	private String flow_direction;
	private java.math.BigDecimal imbalance_price_amount;
	private String imbalance_price_category;
	private java.math.BigDecimal max_price_amount;
	private java.math.BigDecimal min_price_amount;
	private Integer position;
	private java.math.BigDecimal procurement_price_amount;
	private java.math.BigDecimal quantiy;
	private java.math.BigDecimal secondary_quatity;
	private java.math.BigDecimal unavalaible_quantity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public java.math.BigDecimal getActivation_price_amount() {
		return activation_price_amount;
	}
	public void setActivation_price_amount(java.math.BigDecimal activation_price_amount) {
		this.activation_price_amount = activation_price_amount;
	}
	public String getFlow_direction() {
		return flow_direction;
	}
	public void setFlow_direction(String flow_direction) {
		this.flow_direction = flow_direction;
	}
	public java.math.BigDecimal getImbalance_price_amount() {
		return imbalance_price_amount;
	}
	public void setImbalance_price_amount(java.math.BigDecimal imbalance_price_amount) {
		this.imbalance_price_amount = imbalance_price_amount;
	}
	public String getImbalance_price_category() {
		return imbalance_price_category;
	}
	public void setImbalance_price_category(String imbalance_price_category) {
		this.imbalance_price_category = imbalance_price_category;
	}
	public java.math.BigDecimal getMax_price_amount() {
		return max_price_amount;
	}
	public void setMax_price_amount(java.math.BigDecimal max_price_amount) {
		this.max_price_amount = max_price_amount;
	}
	public java.math.BigDecimal getMin_price_amount() {
		return min_price_amount;
	}
	public void setMin_price_amount(java.math.BigDecimal min_price_amount) {
		this.min_price_amount = min_price_amount;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public java.math.BigDecimal getProcurement_price_amount() {
		return procurement_price_amount;
	}
	public void setProcurement_price_amount(java.math.BigDecimal procurement_price_amount) {
		this.procurement_price_amount = procurement_price_amount;
	}
	public java.math.BigDecimal getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(java.math.BigDecimal quantiy) {
		this.quantiy = quantiy;
	}
	public java.math.BigDecimal getSecondary_quatity() {
		return secondary_quatity;
	}
	public void setSecondary_quatity(java.math.BigDecimal secondary_quatity) {
		this.secondary_quatity = secondary_quatity;
	}
	public java.math.BigDecimal getUnavalaible_quantity() {
		return unavalaible_quantity;
	}
	public void setUnavalaible_quantity(java.math.BigDecimal unavalaible_quantity) {
		this.unavalaible_quantity = unavalaible_quantity;
	}

	
	
}
