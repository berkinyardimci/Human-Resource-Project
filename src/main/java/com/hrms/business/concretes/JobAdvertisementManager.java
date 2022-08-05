package com.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import com.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.business.concretes.checkHelper.JobAdvertisementCheckHelper;
import com.hrms.core.strings.ErrorMessages;
import com.hrms.core.strings.SuccessMessages;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	final JobAdvertisementDao jobAdvertisementDao;

	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		var checkFields = !JobAdvertisementCheckHelper.isFillAllFields(jobAdvertisement);
		if (checkFields) {
			return new ErrorResult(ErrorMessages.IsFillFields);
		}

		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(SuccessMessages.dataAdded);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndIsApproved() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndIsApproved(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndIsApprovedOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndIsApprovedOrderByReleaseDateDesc(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndIsApprovedOrderByReleaseDateDesc(int pageNumber,
			int pageSize) {

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndIsApprovedOrderByReleaseDateDesc(pageable));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndIsApprovedAndJob_Position_Id(int jobPositionId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndIsApprovedAndJob_Position_Id(jobPositionId),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndIsApprovedAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndIsApprovedAndEmployer_Id(employerId),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndReleaseDate(LocalDate releaseDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndReleaseDate(releaseDate), SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndId(id),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveAndEmployer_CompanyName(companyName), SuccessMessages.dataListed);
	}

	@Override
	public Result openJobAdvertisement(int jobAdvertisementId) {
		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getReferenceById(jobAdvertisementId);
		setAdvertisement.setActive(true);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}

	@Override
	public Result closeJobAdvertisement(int jobAdvertisementId) {
		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getReferenceById(jobAdvertisementId);
		setAdvertisement.setActive(false);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployerId(employerId),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsNotApproved() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsNotApproved(),
				SuccessMessages.dataListed);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsApproved() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsApproved(),
				SuccessMessages.dataListed);
	}

	@Override
	public Result approveJobAdvertisement(int jobAdvertisementId) {

		JobAdvertisement setAdvertisement = this.jobAdvertisementDao.getReferenceById(jobAdvertisementId);
		setAdvertisement.setApproved(true);

		this.jobAdvertisementDao.save(setAdvertisement);
		return new SuccessResult(SuccessMessages.dataUpdated);
	}

}
