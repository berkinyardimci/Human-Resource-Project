package com.hrms.entities.dtos;

import java.util.List;

import com.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerResumeDto {
	
	private List<JobSeeker> jobSeeker;
	private List<JobSeekerSkill> jobSeekerSkills;
	private List<JobSeekerPicture> jobSeekerPictures;
	private List<JobSeekerLink> jobSeekerLinks;
	private List<JobSeekerLanguage> jobSeekerLanguages;
	private List<JobSeekerExperience> jobSeekerExperiences;
	private List<JobSeekerEducation> jobSeekerEducations;
}
