package com.hrms.business.concretes;

import com.hrms.business.abstracts.OldEmployerService;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.OldEmployerDao;
import com.hrms.entities.concretes.OldEmployer;
import org.springframework.stereotype.Service;


@Service
public class OldEmployerManager implements OldEmployerService {
	
	final OldEmployerDao oldEmployerDao;
	public OldEmployerManager(OldEmployerDao oldEmployerDao) {
		super();
		this.oldEmployerDao = oldEmployerDao;
	}
	
	@Override
	public Result add(OldEmployer oldEmployer) {
		this.oldEmployerDao.save(oldEmployer);
		return new SuccessResult();
	}

	@Override
	public OldEmployer getbyEmployerid(int id) {
		return oldEmployerDao.getByEmployer_id(id);
	}

}
