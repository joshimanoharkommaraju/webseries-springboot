package com.tg.repository;

import com.tg.entity.WebSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSeriesRepository extends JpaRepository<WebSeries,Integer> {
	WebSeries findByName(String name);
}
