package com.sqli.client.rte.bob.reporting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqli.client.rte.bob.reporting.model.EcpTimeSeries;

//public interface EcpTimeSeriesRepository{}
public interface EcpTimeSeriesRepository extends JpaRepository<EcpTimeSeries, Long> {
	
	String ecpTimeSeries_query = "SELECT b.job_instance_id, b.start_time, md.id, count(*) " + 
			"FROM ecpmarketdocument md , batch_job_execution b, batch_job_instance bi, ecptimeseries ts "+
			"where md.start_date = b.start_time " +
			"and md.end_date = b.end_time " + 	
			"and b.job_execution_id = bi.job_instance_id " + 
			"and bi.job_name = :batchName "+ 
			"and b.status = :batchStatus " +
			"and md.id = ts.ecpmarketdocument_id " +
			"group by b.job_instance_id, md.id";
	
	@Query(ecpTimeSeries_query)
	List<Object[]> getEcpTimeSeries(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus); 



}
