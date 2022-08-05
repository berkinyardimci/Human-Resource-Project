package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeekerExperience;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {
	
	List<JobSeekerExperience> getAllByJobSeekerIdOrderByEndDateDesc(int jobSeekerID);

	JobSeekerExperience getById(int jobSeekerId);
}
