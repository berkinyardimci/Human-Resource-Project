package com.hrms.business.concretes;

import java.util.List;

import com.hrms.business.abstracts.JobSeekerLinkService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerLinkDao;
import com.hrms.entities.concretes.JobSeekerLink;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class JobSeekerLinkManager implements JobSeekerLinkService {
	
	final JobSeekerLinkDao seekerLinkDao;


	public JobSeekerLinkManager(JobSeekerLinkDao seekerLinkDao) {
		super();
		this.seekerLinkDao = seekerLinkDao;
	}
	
	@Override
	public Result add(JobSeekerLink jobSeekerLink) {
		this.seekerLinkDao.save(jobSeekerLink);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerLink>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(seekerLinkDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result update(int id, JobSeekerLink jobSeekerLink) {
		var seekerLink=seekerLinkDao.getById(id);
		seekerLink.setLink(jobSeekerLink.getLink());
		seekerLink.setLinkType(jobSeekerLink.getLinkType());
		seekerLink.setJobSeeker(jobSeekerLink.getJobSeeker());
		this.seekerLinkDao.save(seekerLink);
		return new SuccessResult();
	}

}
