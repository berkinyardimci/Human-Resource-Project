package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.OldEmployer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OldEmployerDao extends JpaRepository<OldEmployer, Integer>{
	OldEmployer getByEmployer_id(int id);
}
