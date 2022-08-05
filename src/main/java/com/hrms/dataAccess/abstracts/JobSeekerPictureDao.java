package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeekerPicture;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerPictureDao extends JpaRepository<JobSeekerPicture, Integer>{
	List<JobSeekerPicture> getAllByJobSeekerId(int jobSeekerId);
}
