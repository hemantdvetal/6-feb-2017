package com.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

public class EmployeeDateValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String DATE_PATTERN ="\\^(0?[1-9]|1[0-2])\\/(0?[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$/";
			

	public EmployeeDateValidator() {
		pattern = Pattern.compile(DATE_PATTERN);
	}
	public void validate(final String date,Errors errors) {
        System.out.println("matching regular exp for email ");
		
        if(date.isEmpty()){
        	errors.rejectValue("email", "error.date.blank");
        	
        }else{
        matcher = pattern.matcher(date);
		if(!matcher.matches()){
		errors.rejectValue("email", "error.date");
		}
		
        }
	}
	
	
}
