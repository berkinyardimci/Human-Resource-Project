package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeekerEducation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer>{
	
	List<JobSeekerEducation> getAllByJobSeekerIdOrderByGraduationDateDesc(int jobSeekerId);

	JobSeekerEducation getById(int jobSeekerId);
}
