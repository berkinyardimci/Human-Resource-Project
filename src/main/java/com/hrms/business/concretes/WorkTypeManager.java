package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.WorkTypeService;
import com.hrms.core.strings.SuccessMessages;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.WorkTypeDao;
import com.hrms.entities.concretes.WorkType;
import org.springframework.stereotype.Service;


@Service
public class WorkTypeManager implements WorkTypeService {
	
	final WorkTypeDao workTypeDao;
	
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}
	
	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<>(this.workTypeDao.findAll(), SuccessMessages.dataListed);
	}

}
