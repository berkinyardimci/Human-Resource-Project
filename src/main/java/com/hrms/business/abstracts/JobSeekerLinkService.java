package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerLink;

import java.util.List;



public interface JobSeekerLinkService {
	
	Result add(JobSeekerLink jobSeekerLink);

	DataResult<List<JobSeekerLink>> getAllByJobSeekerId(int jobSeekerId);
	
	Result update(int id,JobSeekerLink jobSeekerLink);
}
