package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.EmployerCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployerCaseDao extends JpaRepository<EmployerCase, Integer> {

}
