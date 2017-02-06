package com.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.Employee;

@Component
public class EmailValidator  {
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	
	public void validate(final String mail,Errors errors) {
        System.out.println("matching regular exp for email ");
		
        if(mail.isEmpty()){
        	errors.rejectValue("email", "error.email.blank");
        	
        }else{
        matcher = pattern.matcher(mail);
		if(!matcher.matches()){
		errors.rejectValue("email", "error.email");
		}
		
        }
	}


	/*@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("Inside email validator.....");
		Employee employee = (Employee)target;
		if (employee.getEmail().isEmpty()) {
			System.out.println("email is empty...");
			errors.rejectValue("email", "error.email");
			
		}else{
			if(!employee.getEmail().contains("@")) {
				System.out.println("email is not empty111...");
			errors.rejectValue("email","", "Email is not validnnnnnnn.");
		    }
	     }
		}*/
	
} 