package com.junit;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.times;
import com.dao.DaoImpl;
import com.model.Department;
import com.model.Employee;
import com.service.EmpServiceImpl;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;


@RunWith(MockitoJUnitRunner.class)
public class TestJunit {

	@InjectMocks
	EmpServiceImpl empService = new EmpServiceImpl();
	 
	@Mock
	DaoImpl daoImpl ;

	
     
	@Test
	public void testfindAllUsers() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		
		List empList= new ArrayList();
		empList.add(empTest);
		
		Mockito.when(daoImpl.findAllUsers()).thenReturn(empList);
		List employeeList = empService.findAllUsers();
		Assert.assertNotNull(employeeList);
		
	}
	
	@Test
	public void testfindAllUsersForFailure() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		
		List empList= new ArrayList();
		empList.add(empTest);
		
		Mockito.when(daoImpl.findAllUsers()).thenReturn(null);
		List employeeList = empService.findAllUsers();
		Assert.assertNull(employeeList);
		
	}
	
	@Test
	public void testSearchEmployeeById() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		
		Mockito.when(daoImpl.searchEmployeeById(Matchers.any(Integer.class))).thenReturn(empTest);
		Employee emp = empService.searchEmployeeById(123);
		Assert.assertNotNull(emp);
		
	}
	
	@Test
	public void testSearchEmployeeByIdForFailure() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		
		Mockito.when(daoImpl.searchEmployeeById(Matchers.any(Integer.class))).thenReturn(null);
		Employee emp = empService.searchEmployeeById(123);
		Assert.assertNull(emp);
		
	}
	
	
	
	
	@Test
	public void testAddUser() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);

		Mockito.when(daoImpl.addUsers(Matchers.any(Employee.class))).thenReturn(12);
		int emp = empService.addUsers(empTest);
		System.out.println(emp);
		Assert.assertTrue(emp>0);

	}
	
	@Test
	public void testAddUserForFailure() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);

		Mockito.when(daoImpl.addUsers(Matchers.any(Employee.class))).thenReturn(0);
		int emp = empService.addUsers(empTest);
		System.out.println(emp);
		Assert.assertTrue(emp<=0);

	}
	
	
	@Test
	public void testeditUser() throws Exception{

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee());
		Mockito.when(daoImpl.editUser(Matchers.any(Integer.class))).thenReturn(list);
		List<Employee> empList = empService.editUser(123);
		System.out.println(empList.size());
		Assert.assertNotNull(empList.get(0));
		
	 }
	
	@Test
	public void testNotEditUserWithoutEmployee() throws Exception{

		//List<Employee> list = new ArrayList();
		
		Mockito.when(daoImpl.editUser(Matchers.any(Integer.class))).thenReturn(null);
		List<Employee> emp = empService.editUser(0);
		//System.out.println(emp.size());
		Assert.assertNull(emp);
		
	}
	
	@Test
	public void testdeleteUser() throws Exception{

		//List<Employee> list = new ArrayList();
		
		Mockito.when(daoImpl.deleteUser(Matchers.any(Integer.class))).thenReturn(1);
		int emp = empService.deleteUser(1);
		//System.out.println(emp.size());
		Assert.assertNotNull(emp);
		
	}
	
	
	@Test
	public void testdeleteUserForFailure() throws Exception{

		Mockito.when(daoImpl.deleteUser(Matchers.any(Integer.class))).thenReturn(0);
		int emp = empService.deleteUser(1);
		Assert.assertTrue(emp==0);
		
	}
	
	@Captor
    ArgumentCaptor<Employee> captor;

	
	@Test
	public void testupdateUsers() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		
		Mockito.doNothing().when(daoImpl).updateUsers(Matchers.any(Employee.class));
		
		empService.updateUsers(empTest);
		
		Mockito.verify(daoImpl, times(1)).updateUsers(captor.capture());
		
		Assert.assertEquals(captor.getValue().getFname(), "dfgdf");
		Assert.assertEquals(captor.getValue().getLname(), "dfgd");

	}

	@Spy
    List<Employee> employees = new ArrayList<Employee>();
 

	@Test
	public void testupdateUsersForFailure() throws Exception{

		Department dept=new Department();
		dept.setDid(123);
		
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		
		Mockito.doThrow(RuntimeException.class).when(daoImpl).updateUsers(null);
		empService.updateUsers(Matchers.any(Employee.class));
    

	}

	
	
	
}
