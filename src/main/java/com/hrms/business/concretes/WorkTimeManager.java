package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.WorkTimeService;
import com.hrms.core.strings.SuccessMessages;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.WorkTimeDao;
import com.hrms.entities.concretes.WorkTime;
import org.springframework.stereotype.Service;


@Service
public class WorkTimeManager implements WorkTimeService {
	
	
	final WorkTimeDao workTimeDao;
	
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		super();
		this.workTimeDao = workTimeDao;
	}
	
	@Override
	public DataResult<List<WorkTime>> getAll() {
		return new SuccessDataResult<>(this.workTimeDao.findAll(), SuccessMessages.dataListed);
	}
}
