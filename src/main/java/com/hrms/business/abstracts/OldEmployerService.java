package com.hrms.business.abstracts;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.OldEmployer;


public interface OldEmployerService {
	Result add(OldEmployer oldEmployer);
	OldEmployer getbyEmployerid(int id);
}
