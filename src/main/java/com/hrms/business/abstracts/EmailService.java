package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;


@Service
public interface EmailService {
	Result sendEmail(User user);
}
