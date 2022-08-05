package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.JobSeekerExperienceService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import com.hrms.entities.concretes.JobSeekerExperience;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {
	
	final JobSeekerExperienceDao seekerExperienceDao;


	public JobSeekerExperienceManager(JobSeekerExperienceDao seekerExperienceDao) {
		super();
		this.seekerExperienceDao = seekerExperienceDao;
	}
	
	@Override
	public Result add(JobSeekerExperience jobSeekerExperience) {
		this.seekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAllByJobSeekerIdOrderByEndDateDesc(int jobSeekerId) {
		return new SuccessDataResult<>(
				seekerExperienceDao.getAllByJobSeekerIdOrderByEndDateDesc(jobSeekerId));
	}

	@Override
	public Result update(int id, JobSeekerExperience jobSeekerExperience) {
		var seekerExperience = seekerExperienceDao.getById(id);
		seekerExperience.setPosition(jobSeekerExperience.getPosition());
		seekerExperience.setWorkplaceName(jobSeekerExperience.getWorkplaceName());
		seekerExperience.setStartDate(jobSeekerExperience.getStartDate());
		seekerExperience.setEndDate(jobSeekerExperience.getEndDate());
		seekerExperience.setJobSeeker(jobSeekerExperience.getJobSeeker());
		this.seekerExperienceDao.save(seekerExperience);
		return new SuccessResult();
	}

}
