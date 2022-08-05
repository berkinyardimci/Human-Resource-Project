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
@Table(name = "job_seeker_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = ErrorMessages.IsFillFields)
	@NotBlank(message = ErrorMessages.IsFillFields)
	@Column(name = "workplace_name")
	private String workplaceName;
	
	@NotNull(message = ErrorMessages.IsFillFields)
	@NotBlank(message = ErrorMessages.IsFillFields)
	@Column(name = "position")
	private String position;

	@NotNull(message = ErrorMessages.IsFillFields)
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;

	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

}
