package com.sqli.client.rte.bob.reporting.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ecpmarketdocument")
public class EcpMarketDocument {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String allocation_decision_date_and_or_time;
	private String control_area_domainmrid;
	private String created_date_time;
	private String doc_status;
	private String end_date;
	private String mrid;
	private String process_process_type;
	private String receive_process_type;
	private String receive_market_participantmrid;
	private String receive_market_participant_role_type;
	private String revision_number;
	private String sender_market_participantmrid;
	private String sender_market_participant_market_role_type;
	private String start_date;
	private String type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAllocation_decision_date_and_or_time() {
		return allocation_decision_date_and_or_time;
	}
	public void setAllocation_decision_date_and_or_time(String allocation_decision_date_and_or_time) {
		this.allocation_decision_date_and_or_time = allocation_decision_date_and_or_time;
	}
	public String getControl_area_domainmrid() {
		return control_area_domainmrid;
	}
	public void setControl_area_domainmrid(String control_area_domainmrid) {
		this.control_area_domainmrid = control_area_domainmrid;
	}
	public String getCreated_date_time() {
		return created_date_time;
	}
	public void setCreated_date_time(String created_date_time) {
		this.created_date_time = created_date_time;
	}
	public String getDoc_status() {
		return doc_status;
	}
	public void setDoc_status(String doc_status) {
		this.doc_status = doc_status;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getMrid() {
		return mrid;
	}
	public void setMrid(String mrid) {
		this.mrid = mrid;
	}
	public String getProcess_process_type() {
		return process_process_type;
	}
	public void setProcess_process_type(String process_process_type) {
		this.process_process_type = process_process_type;
	}
	public String getReceive_process_type() {
		return receive_process_type;
	}
	public void setReceive_process_type(String receive_process_type) {
		this.receive_process_type = receive_process_type;
	}
	public String getReceive_market_participantmrid() {
		return receive_market_participantmrid;
	}
	public void setReceive_market_participantmrid(String receive_market_participantmrid) {
		this.receive_market_participantmrid = receive_market_participantmrid;
	}
	public String getReceive_market_participant_role_type() {
		return receive_market_participant_role_type;
	}
	public void setReceive_market_participant_role_type(String receive_market_participant_role_type) {
		this.receive_market_participant_role_type = receive_market_participant_role_type;
	}
	public String getRevision_number() {
		return revision_number;
	}
	public void setRevision_number(String revision_number) {
		this.revision_number = revision_number;
	}
	public String getSender_market_participantmrid() {
		return sender_market_participantmrid;
	}
	public void setSender_market_participantmrid(String sender_market_participantmrid) {
		this.sender_market_participantmrid = sender_market_participantmrid;
	}
	public String getSender_market_participant_market_role_type() {
		return sender_market_participant_market_role_type;
	}
	public void setSender_market_participant_market_role_type(String sender_market_participant_market_role_type) {
		this.sender_market_participant_market_role_type = sender_market_participant_market_role_type;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
