package com.hrms.api.controllers;

import javax.validation.Valid;

import com.hrms.business.abstracts.JobSeekerLinkService;
import com.hrms.entities.concretes.JobSeekerLink;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jobseekerlinks/")
public class JobSeekerLinksController {
	
	final JobSeekerLinkService seekerLinkService;

	public JobSeekerLinksController(JobSeekerLinkService seekerLinkService) {
		super();
		this.seekerLinkService = seekerLinkService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerLink jobSeekerLink) {
		return ResponseEntity.ok(this.seekerLinkService.add(jobSeekerLink));
	}

	@GetMapping("getAllByJobSeekerId")
	public ResponseEntity<?> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerLinkService.getAllByJobSeekerId(jobSeekerId));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody JobSeekerLink jobSeekerLink) {
		return ResponseEntity.ok(this.seekerLinkService.update(id, jobSeekerLink));

	}
}
