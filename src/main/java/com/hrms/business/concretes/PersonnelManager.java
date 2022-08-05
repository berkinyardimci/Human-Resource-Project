package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.PersonnelService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.PersonnelDao;
import com.hrms.entities.concretes.Personnel;
import org.springframework.stereotype.Service;


@Service
public class PersonnelManager implements PersonnelService {
	
	private PersonnelDao personnelDao;

	
	public PersonnelManager(PersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}

	@Override
	public DataResult<List<Personnel>> getAll() {
		return new SuccessDataResult<>(personnelDao.findAll());
	}
}
