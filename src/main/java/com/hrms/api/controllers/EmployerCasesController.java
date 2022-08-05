package com.hrms.api.controllers;

import java.util.List;

import com.hrms.business.abstracts.EmployerCaseService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.EmployerCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class EmployerCasesController {

	final EmployerCaseService employerCaseService;
	
	public EmployerCasesController(EmployerCaseService employerCaseService) {
		super();
		this.employerCaseService = employerCaseService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<EmployerCase>> getAll(){
		return this.employerCaseService.getAll();
	}
}
