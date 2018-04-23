package com.sqli.client.rte.bob.reporting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sqli.client.rte.bob.reporting.model.Chronicle;

public interface ChronicleRepository extends JpaRepository<Chronicle, Long> {

	@Query("SELECT programmeappel_id, count(*) FROM Chronicle group by programmeappel_id")
	List<Object[]> getPANbChronicles();
}