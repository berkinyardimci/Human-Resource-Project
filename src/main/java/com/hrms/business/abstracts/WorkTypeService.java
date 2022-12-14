package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.WorkType;


public interface WorkTypeService {
	
	DataResult<List<WorkType>> getAll();
}
