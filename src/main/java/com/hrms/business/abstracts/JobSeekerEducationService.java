package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerEducation;


public interface JobSeekerEducationService {
	
	Result add(JobSeekerEducation jobSeekerEducation);

	DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId);

	Result update(int id, JobSeekerEducation jobSeekerEducation);
}
