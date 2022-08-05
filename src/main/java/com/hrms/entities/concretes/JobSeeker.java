package com.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.hrms.core.strings.ErrorMessages;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeeker extends User {
	
	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "last_name")
	private String lastName;
	
	@Size(min = 11, message = "National Id must be 11 characters.")
	@NotBlank(message = ErrorMessages.IsFillFields)
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "national_id")
	private String nationalId;
	

	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerExperience> jobSeekerExperiences;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLink> jobSeekerLinks;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerEducation> jobSeekerEducations;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSkill> jobSeekerSkills;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerPicture> jobSeekerPictures;
	
}
