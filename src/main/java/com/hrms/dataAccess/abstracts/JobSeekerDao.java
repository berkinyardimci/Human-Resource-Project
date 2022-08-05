package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	List<JobSeeker> findByEmail(String email);
	
	List<JobSeeker> findByNationalId(String nationalId);
	
	List<JobSeeker> findById(int id);
}
