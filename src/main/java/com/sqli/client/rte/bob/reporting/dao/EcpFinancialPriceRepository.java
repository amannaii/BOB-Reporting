package com.sqli.client.rte.bob.reporting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqli.client.rte.bob.reporting.model.EcpFinancialPrice;

public interface EcpFinancialPriceRepository extends JpaRepository<EcpFinancialPrice, Long> {
	
/*	String ecpFinancialPrice_query = "SELECT b.job_instance_id, b.start_time, count (*) " + 
			"FROM EcpFinancialPrice s , BatchJobExecution b, BatchJobInstance bi "+
			"where s.start_date = b.start_time " +
			"and s.end_date = b.end_time " + 	
			"and b.job_execution_id = bi.job_instance_id " + 
			"and bi.job_name = :batchName "+ 
			"and b.status = :batchStatus " +
			"group by b.job_instance_id";
	
	@Query(ecpFinancialPrice_query)
	List<Object[]> getEcpFinancialPrice(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus); 
*/

}
