package com.sqli.client.rte.bob.reporting.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqli.client.rte.bob.reporting.model.EcpSeriesPeriod;

public interface EcpSeriesPeriodRepository extends JpaRepository<EcpSeriesPeriod, Long> {
	
	/* @Query("SELECT id FROM EcpSeriesPeriod e " +
			    "where STR_TO_DATE(e.start_date, '%Y-%m-%d %H:%i:%s') > :startDate "+
			    "and STR_TO_DATE(e.end_date, '%Y-%m-%d %H:%i:%s') < :endDate")
			    List<Object[]> findByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    */
	
/*	 String ecpSeriePeriod_query = "SELECT b.job_instance_id, b.start_time, count (*) " + 
				"FROM EcpSeriePeriod s , BatchJobExecution b, BatchJobInstance bi "+
				"where s.start_date = b.start_time " +
				"and s.end_date = b.end_time " + 	
				"and b.job_execution_id = bi.job_instance_id " + 
				"and bi.job_name = :batchName "+ 
				"and b.status = :batchStatus " +
				"group by b.job_instance_id";
	    
	    @Query(ecpSeriePeriod_query)
		List<Object[]> getEcpSeriesPeriod(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus); 
*/
}
