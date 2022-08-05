package com.hrms.business.concretes.checkHelper;

import java.util.Objects;

import com.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {
	public static boolean isFillAllFields(Employer employer) {
		if (employer.getCompanyName().trim().isEmpty() || employer.getWebSite().isEmpty()
				|| employer.getEmail().trim().isEmpty() || employer.getPhoneNumber().trim().isEmpty()
				|| employer.getPassword().trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static boolean isCorrectEmail(Employer employer) {
		String[] emailArray = employer.getEmail().split("@", 2);
		String website = employer.getWebSite();
		if (website.contains("www.")) {
			website = website.substring(4);
		}
		if (emailArray[1].equals(website)) {
			return true;
		}
		return false;
	}
	
	public static boolean isMatchPassword(Employer employer, String passwordConfirm) {
		if (Objects.equals(passwordConfirm, employer.getPassword())) {
			return true;
		}
		return false;
	}
}
