package com.hrms.business.concretes;

import com.hrms.business.abstracts.EmailService;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.entities.concretes.User;
import org.springframework.stereotype.Component;


@Component
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		
		return new SuccessResult("Email sended to "+ user.getEmail());
	}

}
