package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerPicture;
import org.springframework.web.multipart.MultipartFile;


public interface JobSeekerPictureService {
	
	Result add(JobSeekerPicture jobSeekerPicture);

	Result add(JobSeekerPicture jobSeekerPicture, MultipartFile file);

	DataResult<List<JobSeekerPicture>> getAll();

	DataResult<List<JobSeekerPicture>> getAllByJobSeekerId(int jobSeekerId);
}
