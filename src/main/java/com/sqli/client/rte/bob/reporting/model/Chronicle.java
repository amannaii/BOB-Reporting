package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Chronicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
	private String pac_curve_type;
    private String pac_direction;
    private String pac_mrid;
	private String pac_resolution;
    private String pac_type;
    private long programmeappel_id;
    
	@Transient
	private int pointsTotal;
	
    public int getPointsTotal() {
		return pointsTotal;
	}
	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}
	public long getProgrammeappel_id() {
		return programmeappel_id;
	}
	public void setProgrammeappel_id(long programmeappel_id) {
		this.programmeappel_id = programmeappel_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPac_curve_type() {
		return pac_curve_type;
	}
	public void setPac_curve_type(String pac_curve_type) {
		this.pac_curve_type = pac_curve_type;
	}
	public String getPac_direction() {
		return pac_direction;
	}
	public void setPac_direction(String pac_direction) {
		this.pac_direction = pac_direction;
	}
	public String getPac_mrid() {
		return pac_mrid;
	}
	public void setPac_mrid(String pac_mrid) {
		this.pac_mrid = pac_mrid;
	}
	public String getPac_resolution() {
		return pac_resolution;
	}
	public void setPac_resolution(String pac_resolution) {
		this.pac_resolution = pac_resolution;
	}
	public String getPac_type() {
		return pac_type;
	}
	public void setPac_type(String pac_type) {
		this.pac_type = pac_type;
	}

}
