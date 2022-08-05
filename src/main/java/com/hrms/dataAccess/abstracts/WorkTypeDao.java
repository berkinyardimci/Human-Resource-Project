package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{

}
