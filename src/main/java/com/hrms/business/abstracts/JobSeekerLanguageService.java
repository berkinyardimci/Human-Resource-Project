package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerLanguage;


public interface JobSeekerLanguageService {
	
	Result add(JobSeekerLanguage jobSeekerLanguage);

	DataResult<List<JobSeekerLanguage>> getAllByJobSeekerId(int jobSeekerId);

	Result update(int id,JobSeekerLanguage jobSeekerLanguage);
}
