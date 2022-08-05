package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerExperience;


public interface JobSeekerExperienceService {
	
	Result add(JobSeekerExperience jobSeekerExperience);

	DataResult<List<JobSeekerExperience>> getAllByJobSeekerIdOrderByEndDateDesc(int jobSeekerId);

	Result update(int id, JobSeekerExperience jobSeekerExperience);
}
