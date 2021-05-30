package com.tg.controller;

import com.tg.entity.*;
import com.tg.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebSeriesController {
	
	@Autowired
	private WebSeriesService service;
	 
	@PostMapping("/addSeries")
	public WebSeries addSeries(@RequestBody WebSeries webseries) {
		return service.saveSeries(webseries);
	}	

	@GetMapping("/series")
	public List<WebSeries> findAllSeries() {
	    return service.getSeries();
	}
	
	@GetMapping("/series/id/{id}")
	public WebSeries findSeriesById(@PathVariable int id) {
	    return service.getSeriesById(id);
	}
	
	@GetMapping("/series/name/{name}")
	public WebSeries findSeriesByName(@PathVariable String name) {
	    return service.getSeriesByName(name);
	}
	
	@PutMapping("/update")
	public WebSeries updateSeries(@RequestBody WebSeries webseries) {
	    return service.updateSeries(webseries);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSeries(@PathVariable int id) {
	    return service.deleteSeries(id);
	}

}
