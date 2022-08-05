package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonnelDao extends JpaRepository<Personnel, Integer>{

}
