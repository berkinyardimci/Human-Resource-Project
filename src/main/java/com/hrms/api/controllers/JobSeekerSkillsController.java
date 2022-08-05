package com.hrms.api.controllers;

import javax.validation.Valid;

import com.hrms.business.abstracts.JobSeekerSkillService;
import com.hrms.entities.concretes.JobSeekerSkill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/jobseekerskills/")
public class JobSeekerSkillsController {
	
	
	final JobSeekerSkillService seekerSkillService;

	public JobSeekerSkillsController(JobSeekerSkillService seekerSkillService) {
		super();
		this.seekerSkillService = seekerSkillService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerSkill jobSeekerSkill) {
		return ResponseEntity.ok(this.seekerSkillService.add(jobSeekerSkill));
	}

	@GetMapping("getAllByJobSeekerId")
	public ResponseEntity<?> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.seekerSkillService.getAllByJobSeekerId(jobSeekerId));
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody JobSeekerSkill jobSeekerSkill) {
		return ResponseEntity.ok(this.seekerSkillService.update(id, jobSeekerSkill));
	}
}
