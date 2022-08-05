package com.hrms.api.controllers;

import javax.validation.Valid;

import com.hrms.business.abstracts.JobSeekerExperienceService;
import com.hrms.entities.concretes.JobSeekerExperience;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jobseekerexperiences/")
public class JobSeekerExperiencesController {
	
	private JobSeekerExperienceService seekerExperienceService;

	public JobSeekerExperiencesController(JobSeekerExperienceService seekerExperienceService) {
		super();
		this.seekerExperienceService = seekerExperienceService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerExperience jobSeekerExperience) {
		return ResponseEntity.ok(this.seekerExperienceService.add(jobSeekerExperience));
	}
	
	@GetMapping("getAllByJobSeekerIdOrderByEndDateDesc")
	public ResponseEntity<?> getAllByJobSeekerIdOrderByEndDateDesc(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerExperienceService.getAllByJobSeekerIdOrderByEndDateDesc(jobSeekerId));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody JobSeekerExperience jobSeekerExperience) {
		return ResponseEntity.ok(this.seekerExperienceService.update(id, jobSeekerExperience));
	}
}
