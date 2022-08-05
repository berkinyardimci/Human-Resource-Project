package com.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hrms.core.strings.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seeker_educations")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = ErrorMessages.IsFillFields)
	@NotBlank(message = ErrorMessages.IsFillFields)
	@Column(name = "school_name")
	private String schoolName;
	
	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "graduation_date")
	private LocalDate graduationDate;
	
	@NotNull(message = ErrorMessages.IsFillFields)
	@NotBlank(message = ErrorMessages.IsFillFields)
	@Column(name = "department_name")
	private String departmentName;

	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
}
