package com.sqli.client.rte.bob.reporting.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topase_programappel")
public class CallProgram {
	@Id
	private long id;
	private Date pa_consideration_gate;
	private String pa_lifecycle_state;
	private String pa_mrid;
	private String pa_period_end;
	private String pa_period_start;
	private String pa_registred_ressource;
	private String pa_sender_eic;
	private String pa_sender_name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getPa_consideration_gate() {
		return pa_consideration_gate;
	}
	public void setPa_consideration_gate(Date pa_consideration_gate) {
		this.pa_consideration_gate = pa_consideration_gate;
	}
	public String getPa_lifecycle_state() {
		return pa_lifecycle_state;
	}
	public void setPa_lifecycle_state(String pa_lifecycle_state) {
		this.pa_lifecycle_state = pa_lifecycle_state;
	}
	public String getPa_mrid() {
		return pa_mrid;
	}
	public void setPa_mrid(String pa_mrid) {
		this.pa_mrid = pa_mrid;
	}
	public String getPa_period_end() {
		return pa_period_end;
	}
	public void setPa_period_end(String pa_period_end) {
		this.pa_period_end = pa_period_end;
	}
	public String getPa_period_start() {
		return pa_period_start;
	}
	public void setPa_period_start(String pa_period_start) {
		this.pa_period_start = pa_period_start;
	}
	public String getPa_registred_ressource() {
		return pa_registred_ressource;
	}
	public void setPa_registred_ressource(String pa_registred_ressource) {
		this.pa_registred_ressource = pa_registred_ressource;
	}
	public String getPa_sender_eic() {
		return pa_sender_eic;
	}
	public void setPa_sender_eic(String pa_sender_eic) {
		this.pa_sender_eic = pa_sender_eic;
	}
	public String getPa_sender_name() {
		return pa_sender_name;
	}
	public void setPa_sender_name(String pa_sender_name) {
		this.pa_sender_name = pa_sender_name;
	}
	public String getPa_version() {
		return pa_version;
	}
	public void setPa_version(String pa_version) {
		this.pa_version = pa_version;
	}
	private String pa_version;
}
