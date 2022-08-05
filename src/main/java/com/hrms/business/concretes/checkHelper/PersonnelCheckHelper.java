package com.hrms.business.concretes.checkHelper;

import com.hrms.entities.concretes.Employer;


public class PersonnelCheckHelper {
	public static boolean confirmEmployer(Employer employer) {
		System.out.println(employer.getEmail() + " employer is confirmed.");
		return true;
	}
}
