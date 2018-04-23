package com.sqli.client.rte.bob.reporting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqli.client.rte.bob.reporting.model.EcpTimeSeries;

//public interface EcpTimeSeriesRepository{}
public interface EcpTimeSeriesRepository extends JpaRepository<EcpTimeSeries, Long> {
	
	

}
