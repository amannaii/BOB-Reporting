package com.sqli.client.rte.bob.reporting.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "batch_job_execution")
public class BatchJobExecution {
	@Id
	private long job_execution_id;
	private long job_instance_id;
	private Date start_time;
	private Date end_time;
	private String status;
}
