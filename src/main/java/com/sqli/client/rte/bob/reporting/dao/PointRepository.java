package com.sqli.client.rte.bob.reporting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqli.client.rte.bob.reporting.model.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

}