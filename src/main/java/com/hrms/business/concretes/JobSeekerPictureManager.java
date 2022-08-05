package com.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.hrms.business.abstracts.JobSeekerPictureService;
import com.hrms.core.utilities.pictureService.PictureService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerPictureDao;
import com.hrms.entities.concretes.JobSeekerPicture;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class JobSeekerPictureManager implements JobSeekerPictureService {
	
	final JobSeekerPictureDao seekerPictureDao;
	final PictureService pictureService;

	public JobSeekerPictureManager(JobSeekerPictureDao seekerPictureDao, PictureService pictureService) {
		super();
		this.seekerPictureDao = seekerPictureDao;
		this.pictureService = pictureService;
	}
	
	@Override
	public Result add(JobSeekerPicture jobSeekerPicture) {
		this.seekerPictureDao.save(jobSeekerPicture);
		return new SuccessResult();
	}

	@Override
	public Result add(JobSeekerPicture jobSeekerPicture, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) pictureService.save(file).getData();
		String url = result.get("url");
		jobSeekerPicture.setUrl(url);
		jobSeekerPicture.setUploadedDate(LocalDate.now());
		return add(jobSeekerPicture);
	}

	@Override
	public DataResult<List<JobSeekerPicture>> getAll() {
		return new SuccessDataResult<>(this.seekerPictureDao.findAll());
	}

	@Override
	public DataResult<List<JobSeekerPicture>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(this.seekerPictureDao.getAllByJobSeekerId(jobSeekerId));
	}

}
