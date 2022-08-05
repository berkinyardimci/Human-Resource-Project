package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.EmployerCase;

import java.util.List;


public interface EmployerCaseService {
	DataResult<List<EmployerCase>> getAll();
}
