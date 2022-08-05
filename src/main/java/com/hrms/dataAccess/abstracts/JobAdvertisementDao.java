package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("FROM JobAdvertisement Where isActive = True")
	List<JobAdvertisement> getByIsActive();
	
	@Query("FROM JobAdvertisement WHERE isActive = True and isApproved=True")
	List<JobAdvertisement> getByIsActiveAndIsApproved();
	
	@Query("FROM JobAdvertisement WHERE isActive = True and isApproved=True ORDER BY releaseDate DESC")
	List<JobAdvertisement> getByIsActiveAndIsApprovedOrderByReleaseDateDesc();
	
	@Query("FROM JobAdvertisement WHERE isActive = True and isApproved=True ORDER BY releaseDate DESC")
	List<JobAdvertisement> getByIsActiveAndIsApprovedOrderByReleaseDateDesc(Pageable pageable);
	
	@Query("FROM JobAdvertisement WHERE isActive = True and isApproved=True and jobPosition.id=:jobPositionId")
	List<JobAdvertisement> getByIsActiveAndIsApprovedAndJob_Position_Id(int jobPositionId);
	
	@Query("FROM JobAdvertisement WHERE isActive = True and isApproved=True and employer.id=:employerId")
	List<JobAdvertisement> getByIsActiveAndIsApprovedAndEmployer_Id(int employerId);
	
	@Query("FROM JobAdvertisement WHERE isActive = True and releaseDate=:releaseDate")
	List<JobAdvertisement> getByIsActiveAndReleaseDate(LocalDate releaseDate);
	
	@Query("FROM JobAdvertisement WHERE isActive=True and id=:id")
	List<JobAdvertisement> getByIsActiveAndId(int id);
	
	@Query("FROM JobAdvertisement WHERE isActive = True and employer.companyName=:companyName")
	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(String companyName);
	
	List<JobAdvertisement> getAllByEmployerId(int employerId);

	@Query("FROM JobAdvertisement WHERE isApproved = False")
	List<JobAdvertisement> getAllByIsNotApproved();

	@Query("FROM JobAdvertisement WHERE isApproved = True")
	List<JobAdvertisement> getAllByIsApproved();
}







