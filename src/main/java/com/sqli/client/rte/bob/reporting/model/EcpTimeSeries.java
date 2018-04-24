package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class EcpTimeSeries {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private Byte[] acquiring_domainmrid;
	private String business_type;
	private String cancelledts;
	private Byte[] connecting_domainmrid;
	private String currency_unit_name;
	private String curve_type;
	private String flow_direction_direction;
	private String mktpsrtype_psr_type;
	private String mrid;
	private String original_market_product_type;
	private String price_measure_unit_name;
	private String quantity_measure_unit;
	private String standard_market_product_type;
	private String type_market_agreement_type;
	private Long ecpmarketdocument_id;
	
	
	
	public Long getEcpmarketdocument_id() {
		return ecpmarketdocument_id;
	}
	public void setEcpmarketdocument_id(Long ecpmarketdocument_id) {
		this.ecpmarketdocument_id = ecpmarketdocument_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Byte[] getAcquiring_domainmrid() {
		return acquiring_domainmrid;
	}
	public void setAcquiring_domainmrid(Byte[] acquiring_domainmrid) {
		this.acquiring_domainmrid = acquiring_domainmrid;
	}
	public String getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}
	public String getCancelledts() {
		return cancelledts;
	}
	public void setCancelledts(String cancelledts) {
		this.cancelledts = cancelledts;
	}
	public Byte[] getConnecting_domainmrid() {
		return connecting_domainmrid;
	}
	public void setConnecting_domainmrid(Byte[] connecting_domainmrid) {
		this.connecting_domainmrid = connecting_domainmrid;
	}
	public String getCurrency_unit_name() {
		return currency_unit_name;
	}
	public void setCurrency_unit_name(String currency_unit_name) {
		this.currency_unit_name = currency_unit_name;
	}
	public String getCurve_type() {
		return curve_type;
	}
	public void setCurve_type(String curve_type) {
		this.curve_type = curve_type;
	}
	public String getFlow_direction_direction() {
		return flow_direction_direction;
	}
	public void setFlow_direction_direction(String flow_direction_direction) {
		this.flow_direction_direction = flow_direction_direction;
	}
	public String getMktpsrtype_psr_type() {
		return mktpsrtype_psr_type;
	}
	public void setMktpsrtype_psr_type(String mktpsrtype_psr_type) {
		this.mktpsrtype_psr_type = mktpsrtype_psr_type;
	}
	public String getMrid() {
		return mrid;
	}
	public void setMrid(String mrid) {
		this.mrid = mrid;
	}
	public String getOriginal_market_product_type() {
		return original_market_product_type;
	}
	public void setOriginal_market_product_type(String original_market_product_type) {
		this.original_market_product_type = original_market_product_type;
	}
	public String getPrice_measure_unit_name() {
		return price_measure_unit_name;
	}
	public void setPrice_measure_unit_name(String price_measure_unit_name) {
		this.price_measure_unit_name = price_measure_unit_name;
	}
	public String getQuantity_measure_unit() {
		return quantity_measure_unit;
	}
	public void setQuantity_measure_unit(String quantity_measure_unit) {
		this.quantity_measure_unit = quantity_measure_unit;
	}
	public String getStandard_market_product_type() {
		return standard_market_product_type;
	}
	public void setStandard_market_product_type(String standard_market_product_type) {
		this.standard_market_product_type = standard_market_product_type;
	}
	public String getType_market_agreement_type() {
		return type_market_agreement_type;
	}
	public void setType_market_agreement_type(String type_market_agreement_type) {
		this.type_market_agreement_type = type_market_agreement_type;
	}
	
	
	

}
