package com.sqli.client.rte.bob.reporting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqli.client.rte.bob.reporting.model.EcpPoint;

public interface EcpPointRepository extends JpaRepository<EcpPoint, Long> {

}
