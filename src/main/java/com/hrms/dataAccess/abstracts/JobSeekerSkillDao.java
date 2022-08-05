package com.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.entities.concretes.JobSeekerSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill, Integer> {
	List<JobSeekerSkill> getAllByJobSeekerId(int jobSeekerId);

	List<JobSeekerSkill> getById(int jobSeekerId);

}
