package com.hrms.entities.concretes;

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
@Table(name = "job_seeker_links")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = ErrorMessages.IsFillFields)
	@NotBlank(message = ErrorMessages.IsFillFields)
	@Column(name = "link")
	private String link;
	
		@ManyToOne()
		@JoinColumn(name = "link_types_id")
		private LinkType linkType;

		@ManyToOne()
		@JoinColumn(name = "job_seeker_id")
		private JobSeeker jobSeeker;
	
}
