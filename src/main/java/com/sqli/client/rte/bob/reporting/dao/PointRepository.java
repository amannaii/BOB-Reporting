package com.sqli.client.rte.bob.reporting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sqli.client.rte.bob.reporting.model.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
	@Query("select c.programmeappel_id, p.chronicle_id, count(p.id) from Chronicle c, Point p where c.id = p.chronicle_id group by c.id")
	List<Object[]> getChronicleNbPoints();
}