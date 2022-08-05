package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer>{
	
	List<JobSeekerLanguage> getAllByJobSeekerId(int jobSeekerId);

	JobSeekerLanguage getById(int jobSeekerId);
}
