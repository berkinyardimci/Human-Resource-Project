package com.hrms.api.controllers;

import java.util.List;

import com.hrms.business.abstracts.WorkTypeService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.WorkType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/worktypes/")
public class WorkTypesController {
	
	final WorkTypeService workTypeService;


	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}

	@GetMapping("getAll")
	public DataResult<List<WorkType>> getAll() {
		return this.workTypeService.getAll();
	}
}
