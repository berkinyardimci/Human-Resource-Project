package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.dtos.JobSeekerResumeDto;

import java.util.List;


public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();

	Result register(JobSeeker jobSeeker, String passwordConfirm);

	DataResult<JobSeekerResumeDto> getResumeByJobSeekerId(int jobSeekerId);
	
	DataResult<List<JobSeeker>> getById(int jobSeekerId);
	
}
