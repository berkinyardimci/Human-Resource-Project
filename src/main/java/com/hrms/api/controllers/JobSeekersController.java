package com.hrms.api.controllers;

import javax.validation.Valid;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.entities.concretes.JobSeeker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/job_seekers/")
public class JobSeekersController {
	
	final JobSeekerService jobSeekerService;

	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("register")
	public ResponseEntity<?> register(@Valid @RequestBody JobSeeker jobSeeker, String passwordConfirm) {
		return ResponseEntity.ok(this.jobSeekerService.register(jobSeeker, passwordConfirm));
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobSeekerService.getAll());
	}

	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.jobSeekerService.getById(jobSeekerId));
	}

	@GetMapping("getResumeByJobSeekerId")
	public ResponseEntity<?> getResumeByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.jobSeekerService.getResumeByJobSeekerId(jobSeekerId));
	}
}
