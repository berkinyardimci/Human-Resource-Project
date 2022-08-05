package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.JobSeekerLanguageService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import com.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.stereotype.Service;


import lombok.var;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {
	
	final JobSeekerLanguageDao seekerLanguageDao;


	public JobSeekerLanguageManager(JobSeekerLanguageDao seekerLanguageDao) {
		super();
		this.seekerLanguageDao = seekerLanguageDao;
	}
	
	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		this.seekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(seekerLanguageDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result update(int id, JobSeekerLanguage jobSeekerLanguage) {
		var seekerLanguage = seekerLanguageDao.getById(id);
		seekerLanguage.setLanguage(jobSeekerLanguage.getLanguage());
		seekerLanguage.setLevel(jobSeekerLanguage.getLevel());
		seekerLanguage.setJobSeeker(jobSeekerLanguage.getJobSeeker());
		this.seekerLanguageDao.save(seekerLanguage);
		return new SuccessResult();
	}

}
