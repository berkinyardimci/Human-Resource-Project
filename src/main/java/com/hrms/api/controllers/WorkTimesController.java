package com.hrms.api.controllers;

import java.util.List;

import com.hrms.business.abstracts.WorkTimeService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.WorkTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/worktimes/")
public class WorkTimesController {
	
	private WorkTimeService workTimeService;


	public WorkTimesController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}

	@GetMapping("getAll")
	public DataResult<List<WorkTime>> getAll() {
		return this.workTimeService.getAll();
	}
}
