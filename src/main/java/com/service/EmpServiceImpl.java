package com.service;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.model.Employee;


@Service
public class EmpServiceImpl implements EmpService { 
     
	
	@Autowired
	private Dao dao1;
	    
	
	@Transactional(readOnly = true,propagation=Propagation.REQUIRED)
	public Employee searchEmployeeById(int id){
		return dao1.searchEmployeeById(id);
	}
	
	
	public List<Employee> findAllUsers() {
		System.out.println("In service impl.........");
		return dao1.findAllUsers();
	}
	
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public int addUsers(Employee emp){
		System.out.println("In insert service");
		int empId = dao1.addUsers(emp);
		return empId;
		
	}
	
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public int deleteUser(int id) {
		return dao1.deleteUser(id);
		
	}

	public List<Employee> editUser(int id) {
		return dao1.editUser(id);
	}

	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public void updateUsers(Employee emp) {
		 dao1.updateUsers(emp);
		
	}

	public List fetchAllDetails() {
		
		return dao1.fetchAllDetails();
	} 

	public List getDepartmentList() {
		return dao1.getDepartmentList();
    }

	public int getDepartmentDetails(String deptName) {
		int i = dao1.getDepartmentDetails(deptName);
		return i;
	}


	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}


	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

}
