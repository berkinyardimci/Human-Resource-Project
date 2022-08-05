package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seeker_languages")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Min(value = 1, message = "En küçük değer 1 olmalıdır.")
	@Min(value = 5, message = "En büyük değer 5 olmalıdır.")
	@NotNull
	@Column(name = "level")
	private short level;
	
	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;

	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
}
