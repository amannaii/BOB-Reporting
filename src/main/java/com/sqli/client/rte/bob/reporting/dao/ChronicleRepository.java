package com.sqli.client.rte.bob.reporting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqli.client.rte.bob.reporting.model.Chronicle;

public interface ChronicleRepository extends JpaRepository<Chronicle, Long> {

}