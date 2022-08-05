package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeekerLink;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerLinkDao extends JpaRepository<JobSeekerLink, Integer> {
	
	List<JobSeekerLink> getAllByJobSeekerId(int jobSeekerId);

	JobSeekerLink getById(int jobSeekerId);

}
