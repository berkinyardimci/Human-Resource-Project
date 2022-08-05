package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.EmployerCaseService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.EmployerCaseDao;
import com.hrms.entities.concretes.EmployerCase;
import org.springframework.stereotype.Service;


@Service
public class EmployerCaseManager implements EmployerCaseService {
	
	final EmployerCaseDao employerCaseDao;
	public EmployerCaseManager(EmployerCaseDao employerCaseDao) {
		super();
		this.employerCaseDao = employerCaseDao;
	}
	
	@Override
	public DataResult<List<EmployerCase>> getAll() {
		return new SuccessDataResult<>(employerCaseDao.findAll());
	}

}
