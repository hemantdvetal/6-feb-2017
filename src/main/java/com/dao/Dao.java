package com.dao;

import java.util.List;

import com.model.Employee;

public interface Dao {
	
	public List<Employee> findAllUsers();
	
	public int  addUsers(Employee emp);
	
	public Employee searchEmployeeById(int id);
	
	public int deleteUser(int id);
	
	public List<Employee> editUser(int id);
	
	public void updateUsers(Employee emp);
	
	public List fetchAllDetails();
	
	public List getDepartmentList();
	
	public int getDepartmentDetails(String deptName);

}
