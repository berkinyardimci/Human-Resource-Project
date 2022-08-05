package com.hrms.core.utilities.results;
import lombok.Data;

@Data
public class Result {
	
	private boolean succes;
	private String message;
	
	
	public Result(boolean succes) {
		this.succes = succes;
	}
	
	public Result(boolean succes,String message) {
		this.succes = succes;
		this.message = message;
	}

	
	public boolean isSucces() {
		return succes;
	}
	public String getMessage() {
		return message;
	}


}
