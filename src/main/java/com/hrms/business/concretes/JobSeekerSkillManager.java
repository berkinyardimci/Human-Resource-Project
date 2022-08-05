package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.JobSeekerSkillService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerSkillDao;
import com.hrms.entities.concretes.JobSeekerSkill;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService {
	
	final JobSeekerSkillDao seekerSkillDao;

	public JobSeekerSkillManager(JobSeekerSkillDao seekerSkillDao) {
		super();
		this.seekerSkillDao = seekerSkillDao;
	}
	
	
	@Override
	public Result add(JobSeekerSkill jobSeekerSkill) {
		this.seekerSkillDao.save(jobSeekerSkill);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(seekerSkillDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result update(int id, JobSeekerSkill jobSeekerSkill) {
		var seekerSkill = seekerSkillDao.getById(id).get(0);
		seekerSkill.setName(jobSeekerSkill.getName());
		seekerSkill.setJobSeeker(jobSeekerSkill.getJobSeeker());
		this.seekerSkillDao.save(seekerSkill);
		return new SuccessResult();
	}

}
