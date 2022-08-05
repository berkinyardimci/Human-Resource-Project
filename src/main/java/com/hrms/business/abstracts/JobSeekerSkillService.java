package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerSkill;


public interface JobSeekerSkillService {
	
	Result add(JobSeekerSkill jobSeekerSkill);

	DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobSeekerId);

	Result update(int id, JobSeekerSkill jobSeekerSkill);
}
