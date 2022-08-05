package com.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import com.hrms.business.abstracts.*;
import com.hrms.core.strings.SuccessMessages;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.dtos.JobSeekerResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.var;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private EmailService emailService;
	
	private JobSeekerSkillService seekerSkillService;
	private JobSeekerPictureService seekerPictureService;
	private JobSeekerLinkService seekerLinkService;
	private JobSeekerLanguageService seekerLanguageService;
	private JobSeekerEducationService seekerEducationService;
	private JobSeekerExperienceService seekerExperienceService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailService emailService,
			JobSeekerSkillService seekerSkillService,JobSeekerPictureService seekerPictureService,
			JobSeekerLinkService seekerLinkService, JobSeekerLanguageService seekerLanguageService,
			JobSeekerEducationService seekerEducationService, JobSeekerExperienceService seekerExperienceService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailService = emailService;
		this.seekerSkillService = seekerSkillService;
		this.seekerPictureService = seekerPictureService;
		this.seekerLinkService = seekerLinkService;
		this.seekerLanguageService = seekerLanguageService;
		this.seekerEducationService = seekerEducationService;
		this.seekerExperienceService = seekerExperienceService;
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<>(this.jobSeekerDao.findAll());
	}

	@Override
	public Result register(JobSeeker jobSeeker, String passwordConfirm) {
		/*var isRealPerson = !this.userCheckService.isRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getNationalId(), jobSeeker.getBirthOfDate());*/
		var checkEmail = this.jobSeekerDao.findByEmail(jobSeeker.getEmail()).size() != 0;
		var checkNationalId = this.jobSeekerDao.findByNationalId(jobSeeker.getNationalId()).size() != 0;
		var checkPassword = !Objects.equals(passwordConfirm, jobSeeker.getPassword());

		if (checkEmail || checkNationalId || checkPassword) {
			String errorMessage = "";

			/*if (isRealPerson) {
				errorMessage = "Mernis Error. Bilgiler doğrulanamadı.";}*/

			if (checkEmail || checkNationalId) {
				errorMessage = "Email adresi veya Kimlik bilgileri zaten mevcut.";
			}

			if (checkPassword) {
				errorMessage = "Parolalar eşleşmiyor.";
			}

			return new ErrorResult("Job Seeker Error: " + errorMessage);
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker added and " + emailService.sendEmail(jobSeeker).getMessage());
	}

	@Override
	public DataResult<JobSeekerResumeDto> getResumeByJobSeekerId(int jobSeekerId) {
		JobSeekerResumeDto jobSeekerResumeDto = new JobSeekerResumeDto();
		jobSeekerResumeDto.setJobSeeker(this.getById(jobSeekerId).getData()); // liste çevirildi hata verebilir
		jobSeekerResumeDto.setJobSeekerEducations(
				this.seekerEducationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerExperiences(
				this.seekerExperienceService.getAllByJobSeekerIdOrderByEndDateDesc(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerLanguages(this.seekerLanguageService.getAllByJobSeekerId(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerLinks(this.seekerLinkService.getAllByJobSeekerId(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerPictures(this.seekerPictureService.getAllByJobSeekerId(jobSeekerId).getData());
		jobSeekerResumeDto.setJobSeekerSkills(this.seekerSkillService.getAllByJobSeekerId(jobSeekerId).getData());
		return new SuccessDataResult<JobSeekerResumeDto>(jobSeekerResumeDto);
	}
	
	@Override
	public DataResult<List<JobSeeker>> getById(int jobSeekerId) {
		return new SuccessDataResult(this.jobSeekerDao.findById(jobSeekerId), SuccessMessages.dataListed);
	}
	


	
	
}
