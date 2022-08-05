package com.hrms.api.controllers;

import java.util.List;

import com.hrms.business.abstracts.CityService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cities/")
public class CitiesController {
	
	final CityService cityService;
	
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
}
