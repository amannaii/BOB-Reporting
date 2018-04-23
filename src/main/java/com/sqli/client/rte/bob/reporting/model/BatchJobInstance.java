package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "batch_job_instance")
public class BatchJobInstance {
	  @Id
	  private long job_instance_id;
	  private long version;
	  private String job_name;
	  private String job_key;
	  
}
