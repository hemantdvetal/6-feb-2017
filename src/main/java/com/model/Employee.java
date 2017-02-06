package com.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Employee")
public class Employee implements Serializable{
	
	
	 
   public Employee(){
	   
	   
   }
   public Employee(String fname){
	   this.fname= fname;
	   
   }
   public Employee(int id, String fname, String lname) {
	
	this.id = id;
	this.fname = fname;
	this.lname = lname;
   }
  
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="emp_seq")
   @SequenceGenerator(name="emp_seq" ,sequenceName="EMPLOYEE_SEQ1",allocationSize=1 )
   private int id;
   
   @Column(name="FIRSTNAME")
   private String fname;
   
   @Column(name="LASTNAME")
   private String lname;
   
   @Temporal(TemporalType.DATE)
   @Column(name="dob")
   @DateTimeFormat(pattern = "dd/MM/yyyy")
   private Date dob;
   
   @Column(name="ADDRESS")
   private String address;
   
   @Column(name="EMAIL")
   private String email;
      
   //private int deptid;
   
   @Column(name="CREATEDDATE")
   private Timestamp createddate;
   
   @Column(name="MODIFIEDDATE")
   private Timestamp modifieddate;
   
   @ManyToOne
   @JoinColumn(name="DEPTID",updatable=true, insertable=true)
   private Department department;
    
   
   
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}*/
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + fname
                + ", lastName=" + lname + ", email=" + email + "]";
    }


}
