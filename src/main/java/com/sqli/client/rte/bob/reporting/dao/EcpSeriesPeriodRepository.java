package com.sqli.client.rte.bob.reporting.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqli.client.rte.bob.reporting.model.EcpSeriesPeriod;

public interface EcpSeriesPeriodRepository extends JpaRepository<EcpSeriesPeriod, Long> {
	
	 @Query("SELECT id FROM EcpSeriesPeriod e " +
			    "where STR_TO_DATE(e.start_date, '%Y-%m-%d %H:%i:%s') > :startDate "+
			    "and STR_TO_DATE(e.end_date, '%Y-%m-%d %H:%i:%s') < :endDate")
			    List<Object[]> findByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
