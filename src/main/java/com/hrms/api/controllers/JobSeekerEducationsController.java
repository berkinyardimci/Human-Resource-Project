package com.hrms.api.controllers;

import javax.validation.Valid;

import com.hrms.business.abstracts.JobSeekerEducationService;
import com.hrms.entities.concretes.JobSeekerEducation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jobseekereducations/")
public class JobSeekerEducationsController {
	
	final JobSeekerEducationService seekerEducationService;
	
	public JobSeekerEducationsController(JobSeekerEducationService seekerEducationService) {
		super();
		this.seekerEducationService = seekerEducationService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerEducation jobSeekerEducation) {
		return ResponseEntity.ok(this.seekerEducationService.add(jobSeekerEducation));
	}
	
	@GetMapping("getAllByJobSeekerIdOrderByGraduationDateDesc")
	public ResponseEntity<?> getAllByJobSeekerIdOrderByGraduationDateDesc(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerEducationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody JobSeekerEducation jobSeekerEducation) {
		return ResponseEntity.ok(this.seekerEducationService.update(id, jobSeekerEducation));
	}
}
