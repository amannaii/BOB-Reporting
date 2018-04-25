package com.sqli.client.rte.bob.reporting.model;

import java.util.Date;

public class EcpStandardOffer {
	
	private Long batch_id;
	private Date start_time;
	private Long ecp_document_id;
	private int ecpTimeSeries_Total;
	private Long ecp_timeseries_id;
	private int ecpseriesperiod_Total;
	private Long ecp_seriesperiod_id;
	private int ecp_point_Total;
	private Long ecp_point_id;
	private int ecp_financialprice_Total;
	
	public Long getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(Long batch_id) {
		this.batch_id = batch_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Long getEcp_document_id() {
		return ecp_document_id;
	}
	public void setEcp_document_id(Long ecp_document_id) {
		this.ecp_document_id = ecp_document_id;
	}
	public int getEcpTimeSeries_Total() {
		return ecpTimeSeries_Total;
	}
	public void setEcpTimeSeries_Total(int ecpTimeSeries_Total) {
		this.ecpTimeSeries_Total = ecpTimeSeries_Total;
	}
	public Long getEcp_timeseries_id() {
		return ecp_timeseries_id;
	}
	public void setEcp_timeseries_id(Long ecp_timeseries_id) {
		this.ecp_timeseries_id = ecp_timeseries_id;
	}
	public int getEcpseriesperiod_Total() {
		return ecpseriesperiod_Total;
	}
	public void setEcpseriesperiod_Total(int ecpseriesperiod_Total) {
		this.ecpseriesperiod_Total = ecpseriesperiod_Total;
	}
	public Long getEcp_seriesperiod_id() {
		return ecp_seriesperiod_id;
	}
	public void setEcp_seriesperiod_id(Long ecp_seriesperiod_id) {
		this.ecp_seriesperiod_id = ecp_seriesperiod_id;
	}
	public int getEcp_point_Total() {
		return ecp_point_Total;
	}
	public void setEcp_point_Total(int ecp_point_Total) {
		this.ecp_point_Total = ecp_point_Total;
	}
	public Long getEcp_point_id() {
		return ecp_point_id;
	}
	public void setEcp_point_id(Long ecp_point_id) {
		this.ecp_point_id = ecp_point_id;
	}
	public int getEcp_financialprice_Total() {
		return ecp_financialprice_Total;
	}
	public void setEcp_financialprice_Total(int ecp_financialprice_Total) {
		this.ecp_financialprice_Total = ecp_financialprice_Total;
	}
	
}
