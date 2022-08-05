package com.hrms.api.controllers;

import java.util.List;

import com.hrms.business.abstracts.PersonnelService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.Personnel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/personnels")
public class PersonnelsController {
	
	final PersonnelService personnelService;

	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Personnel>> getAll() {
		return this.personnelService.getAll();
	}
}
