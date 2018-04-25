package com.sqli.client.rte.bob.reporting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqli.client.rte.bob.reporting.model.EcpMarketDocument;

public interface EcpMarketDocumentRepository extends JpaRepository<EcpMarketDocument, Long> {

	String ecpMarketDocument_query = "SELECT b.job_instance_id, b.start_time, count (*) "
			+ "FROM EcpMarketDocument s , BatchJobExecution b, BatchJobInstance bi "
			+ "where s.start_date = b.start_time " + "and s.end_date = b.end_time "
			+ "and b.job_execution_id = bi.job_instance_id " + "and bi.job_name = :batchName "
			+ "and b.status = :batchStatus " + "group by b.job_instance_id";

	@Query(ecpMarketDocument_query)
	List<Object[]> getEcpMarketDocument(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);

	String ecpTimeSeries_query = "SELECT b.job_instance_id, b.start_time, md.id, ts.id, count(*) "
			+ "FROM EcpMarketDocument md , BatchJobExecution b, BatchJobInstance bi, EcpTimeSeries ts, EcpSeriesPeriod sp "
			+ "where md.start_date = b.start_time " 
			+ "and md.end_date = b.end_time "
			+ "and b.job_execution_id = bi.job_instance_id " 
			+ "and bi.job_name = :batchName "
			+ "and b.status = :batchStatus "
			+ "and md.id = ts.ecpmarketdocument_id "
			+ "and ts.id = sp.ecptimeseries_id "
			+ "group by b.job_instance_id, ts.ecpmarketdocument_id, ts.id";

	@Query(ecpTimeSeries_query)
	List<Object[]> getEcpTimesSeries(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);

	String ecpSeriesPeriod_query = "SELECT b.job_instance_id, b.start_time, md.id, ts.id, count(sp.id) "
			+ "FROM BatchJobExecution b  INNER JOIN EcpMarketDocument md  ON md.start_date = b.start_time AND md.end_date = b.end_time "
			+ "INNER JOIN BatchJobInstance bi ON b.job_execution_id = bi.job_instance_id AND bi.job_name = :batchName AND b.status = :batchStatus "
			+ "INNER JOIN EcpTimeSeries ts ON md.id = ts.ecpmarketdocument_id "
			+ "INNER JOIN EcpSeriesPeriod sp ON ts.id = sp.ecptimeseries_id "
			+ "group by  b.job_instance_id, md.id, ts.id";

	@Query(ecpSeriesPeriod_query)
	List<Object[]> getEcpSeriesPeriod(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);

	
	String ecppoint_query = "SELECT b.job_instance_id, b.start_time, md.id, ts.id,sp.id ,count(ep.id) "
			+ "FROM BatchJobExecution b  INNER JOIN EcpMarketDocument md  ON md.start_date = b.start_time AND md.end_date = b.end_time "
			+ "INNER JOIN BatchJobInstance bi ON b.job_execution_id = bi.job_instance_id AND bi.job_name = :batchName AND b.status = :batchStatus "
			+ "INNER JOIN EcpTimeSeries ts ON md.id = ts.ecpmarketdocument_id "
			+ "INNER JOIN EcpSeriesPeriod sp ON ts.id = sp.ecptimeseries_id "
			+ "INNER JOIN EcpPoint ep ON sp.id = ep.ecpseriesperiod_id "
			+ "group by  b.job_instance_id, md.id, ts.id,sp.id";

	@Query(ecppoint_query)
	List<Object[]> getEcpPoint(@Param("batchName") String batchName, @Param("batchStatus") String batchStatus);
}
