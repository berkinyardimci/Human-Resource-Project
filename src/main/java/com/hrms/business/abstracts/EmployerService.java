package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.EmployerCase;

import java.util.List;


public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<List<Employer>> getEmployerById(int id);
	
	Result register(Employer employer, String passwordConfirm);
	
	Result update(int id,Employer employer);
	
	Result ConfirmUpdate(EmployerCase employerCase, int EmployerId);

	DataResult<List<Employer>> getByIdForUsers(int id);
	
	DataResult<List<Employer>> getByIdForAdmins(int id);

    DataResult<List<Employer>> getByEmployerCase_id();
}
