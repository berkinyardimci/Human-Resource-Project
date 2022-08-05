package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.WorkTime;

import java.util.List;



public interface WorkTimeService {
	
	DataResult<List<WorkTime>> getAll();
}
