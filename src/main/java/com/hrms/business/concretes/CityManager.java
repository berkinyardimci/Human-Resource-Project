package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.CityService;
import com.hrms.core.strings.SuccessMessages;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.CityDao;
import com.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;


@Service
public class CityManager implements CityService {
	
	final CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<>(this.cityDao.findAll(), SuccessMessages.dataListed);
	}

}
