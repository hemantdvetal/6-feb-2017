package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department implements Serializable {
	@Id 
	private int did;
	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	private String name;
	private String location;
	private Date createdDate;
	
	
	
	
	 


	public Department() {
		super();
	}

	
	 //many to one working code 
	/* @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Set<Employee> employee;*/
    
	// @ManyToOne(fetch = FetchType.EAGER)
     //@JoinColumn(name = "id")
    // private Employee employee;

	

	/*public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/

	 /*@ManyToOne()
	 private Employee employee;*/
	 
	 @OneToMany(mappedBy="department")
		private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


}
