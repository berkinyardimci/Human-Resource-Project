package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.JobSeekerEducationService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerEducationDao;
import com.hrms.entities.concretes.JobSeekerEducation;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {
	
	
	final JobSeekerEducationDao seekerEducationDao;
	
	public JobSeekerEducationManager(JobSeekerEducationDao seekerEducationDao) {
		super();
		this.seekerEducationDao = seekerEducationDao;
	}
	
	@Override
	public Result add(JobSeekerEducation jobSeekerEducation) {
		this.seekerEducationDao.save(jobSeekerEducation);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId) {
		return new SuccessDataResult<>(
				seekerEducationDao.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId));
	}

	@Override
	public Result update(int id, JobSeekerEducation jobSeekerEducation) {
		var seekerEducation = seekerEducationDao.getById(id);
		seekerEducation.setDepartmentName(jobSeekerEducation.getDepartmentName());
		seekerEducation.setSchoolName(jobSeekerEducation.getSchoolName());
		seekerEducation.setStartDate(jobSeekerEducation.getStartDate());
		seekerEducation.setGraduationDate(jobSeekerEducation.getGraduationDate());
		seekerEducation.setJobSeeker(jobSeekerEducation.getJobSeeker());
		this.seekerEducationDao.save(seekerEducation);
		return new SuccessResult();
	}

}
