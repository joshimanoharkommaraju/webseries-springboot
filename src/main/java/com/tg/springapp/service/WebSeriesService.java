package com.tg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.entity.*;
import com.tg.repository.*;

@Service
public class WebSeriesService {
	
	@Autowired
    private WebSeriesRepository repository;
	
	public WebSeries saveSeries(WebSeries webseries) {
        return repository.save(webseries);
    }
	
	public List<WebSeries> getSeries() {
        return repository.findAll();
    }
	
	public WebSeries getSeriesById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public WebSeries getSeriesByName(String name) {
        return repository.findByName(name);
    }
	
	public String deleteSeries(int id) {
        repository.deleteById(id);
        return "Series Removed ! " + id;
    }

	public WebSeries updateSeries(WebSeries webseries) {
        WebSeries existingSeries = repository.findById(webseries.getId()).orElse(null);
        existingSeries.setName(webseries.getName());
        existingSeries.setSeasons(webseries.getSeasons());
        existingSeries.setEpisodes(webseries.getEpisodes());
        existingSeries.setRating(webseries.getRating());
        return repository.save(existingSeries);
    }

}
