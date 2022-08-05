package com.hrms.business.concretes.checkHelper;

import com.hrms.entities.concretes.JobAdvertisement;


public class JobAdvertisementCheckHelper {
	
	public static boolean isFillAllFields(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getDescription().trim().isEmpty()
				|| jobAdvertisement.getApplicationDeadline().toString().trim().isEmpty()
				|| jobAdvertisement.getReleaseDate().toString().trim().isEmpty()
				|| jobAdvertisement.getCountOfOpenPositions() == 0 || jobAdvertisement.getJobPosition().getId() == 0
				|| jobAdvertisement.getEmployer().getId() == 0
		) {
			return false;
		}
		return true;
	}
}
