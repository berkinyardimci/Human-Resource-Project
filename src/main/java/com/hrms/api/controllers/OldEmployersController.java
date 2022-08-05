package com.hrms.api.controllers;

import com.hrms.business.abstracts.OldEmployerService;
import com.hrms.entities.concretes.OldEmployer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/oldEmployers/")
public class OldEmployersController {

	final OldEmployerService oldEmployerService;

	public OldEmployersController(OldEmployerService oldEmployerService) {
		super();
		this.oldEmployerService = oldEmployerService;
	}

	@GetMapping("getbyEmployerid")
	public OldEmployer getbyEmployerid(int id) {
		return this.oldEmployerService.getbyEmployerid(id);
	}

}
