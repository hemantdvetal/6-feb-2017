package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.Employee;

public class CustomerValidator implements Validator{

	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Employee.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		System.out.println("In custom validator..........");
		Employee employee = (Employee)target;
		
		
		if (employee.getFname().isEmpty()) {
			errors.rejectValue("fname", "error.lname");
			
		}
		if (employee.getLname().isEmpty()) {
			errors.rejectValue("lname", "error.lname");
			
		}
		if (employee.getDob()==null) {
			errors.rejectValue("dob", "error.dob");
			
		}
		
		if (employee.getAddress().isEmpty()) {
			errors.rejectValue("address", "error.address");
			
		}
		if (employee.getEmail().isEmpty()) {
			errors.rejectValue("email", "error.email");
			
		}
		
		
	}
	
}