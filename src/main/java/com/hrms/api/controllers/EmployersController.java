package com.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.hrms.business.abstracts.EmployerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.EmployerCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employers/")
public class EmployersController {
	
	final EmployerService employerService;
	
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@GetMapping("getEmployerById")
	public DataResult<List<Employer>> getEmployerById(@RequestParam int id) {
		return this.employerService.getEmployerById(id);
	}
	
	@PostMapping("register")
	public Result register(@RequestBody Employer employer, String passwordConfirm) {
		return this.employerService.register(employer, passwordConfirm);
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestParam int id, @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.update(id, employer));
	}
	@PostMapping("ConfirmUpdate")
    public Result ConfirmUpdate(@RequestBody EmployerCase employerCase, @RequestParam int EmployerId) {
        return this.employerService.ConfirmUpdate(employerCase,EmployerId);
    }
	
	@GetMapping("getByIdForUsers")
    public DataResult<List<Employer>> getByIdForUsers(@RequestParam int id){
         return this.employerService.getByIdForUsers(id);
    }
    @GetMapping("getByIdForAdmins")
    public DataResult<List<Employer>> getByIdForAdmins(@RequestParam int id){
         return this.employerService.getByIdForAdmins(id);
    }

    @GetMapping("getByEmployerCaseId")
    public DataResult<List<Employer>> getByEmployerCase_id() {
        return this.employerService.getByEmployerCase_id();
    }
}
