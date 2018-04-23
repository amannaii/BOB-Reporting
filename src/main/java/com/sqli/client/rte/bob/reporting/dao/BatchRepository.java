package com.sqli.client.rte.bob.reporting.dao;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqli.client.rte.bob.reporting.model.BatchJobExecution;

public interface BatchRepository extends JpaRepository<BatchJobExecution, Long> {
	
	String offer_query = "SELECT b.job_instance_id, b.start_time, count (*) " + 
			"FROM SygaOffer s , BatchJobExecution b, BatchJobInstance bi "+
			"where s.heure_debut = b.start_time " +
			"and s.heure_fin = b.end_time " + 	
			"and b.job_execution_id = bi.job_instance_id " + 
			"and bi.job_name = :batchName "+ 
			"and b.status = :batchStatus " +
			"group by b.job_instance_id";
	
	@Query(offer_query)
	List<Object[]> getSygaOffers(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);
	
	String rejected_offer_query = "SELECT b.job_instance_id, b.start_time, count (*) " + 
			"FROM SygaOfferRejected s , BatchJobExecution b, BatchJobInstance bi "+
			"where s.heure_debut = b.start_time " +
			"and s.heure_fin = b.end_time " + 	
			"and b.job_execution_id = bi.job_instance_id " + 
			"and bi.job_name = :batchName "+ 
			"and b.status = :batchStatus " +
			"group by b.job_instance_id";

	@Query(rejected_offer_query)
	List<Object[]> getSygaRejectedOffers(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);
	
	String erroneous_offer_query = "SELECT b.job_instance_id, b.start_time, count (*) " + 
			"FROM SygaOfferErroneous s , BatchJobExecution b, BatchJobInstance bi "+
			"where s.heure_debut = b.start_time " +
			"and s.heure_fin = b.end_time " + 	
			"and b.job_execution_id = bi.job_instance_id " + 
			"and bi.job_name = :batchName "+ 
			"and b.status = :batchStatus " +
			"group by b.job_instance_id";
	
	@Query(erroneous_offer_query)
	List<Object[]> getSygaErrorneousOffers(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);
	


}