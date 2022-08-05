package com.hrms.business.concretes.checkHelper;

import com.hrms.entities.concretes.JobSeeker;


public class JobSeekerCheckHelper {
	
	public static boolean isFillAllFields(JobSeeker jobSeeker, String passwordConfirm) {

		if (jobSeeker.getEmail().trim().isEmpty() || jobSeeker.getPassword().trim().isEmpty()
				|| jobSeeker.getFirstName().trim().isEmpty() || jobSeeker.getLastName().trim().isEmpty()
				|| jobSeeker.getNationalId().trim().isEmpty()
				|| jobSeeker.getBirthDate().toString().trim().isEmpty() || passwordConfirm.trim().isEmpty()) {

			return false;
		}
		return true;

	};
}
