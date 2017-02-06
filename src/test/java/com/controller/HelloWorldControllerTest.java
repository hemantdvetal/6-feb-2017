package com.controller;

import static org.junit.Assert.*;

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
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.model.Department;
import com.model.Employee;
import com.service.EmpServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest { 
	@InjectMocks
	HelloWorldController controller = new HelloWorldController();

	@Mock
	EmpServiceImpl empService;
 
	@Mock
	BindingResult result;

	@Mock
	Model m;

	@Test
	public void testSearchEmployeeById() throws Exception {

		Department dept = new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);

		Mockito.when(empService.searchEmployeeById(Matchers.anyInt())).thenReturn(empTest);
		ModelAndView modelAndView = controller.fetchEmployee(empTest, result, m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertEquals("index", modelAndView.getViewName());
	}
	
	@Test
	public void testSearchEmployeeByIdForFailure() throws Exception {

		Employee empTest = new Employee();
		empTest.setId(0);
	

		Mockito.when(empService.searchEmployeeById(Matchers.eq(0))).thenReturn(empTest);
		ModelAndView modelAndView = controller.fetchEmployee(empTest, result, m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotEquals("index11", modelAndView.getViewName());
	}
	
	@Test
	public void testdeleteEmployee() throws Exception {

		Mockito.when(empService.deleteUser(Matchers.anyInt())).thenReturn(123);
		ModelAndView modelAndView = controller.deleteEmployee("123",m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertEquals("index", modelAndView.getViewName());
	}
	
	@Test
	public void testdeleteEmployeeforFailure() throws Exception {

		Mockito.when(empService.deleteUser(Matchers.anyInt())).thenReturn(123);
		ModelAndView modelAndView = controller.deleteEmployee("0",m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertNotEquals("index2", modelAndView.getViewName());
	}
	
	
	@Test
	public void testEditEmployee() throws Exception {
		Department dept = new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		List tempList = new ArrayList();
		tempList.add(empTest);
		
		
		Mockito.when(empService.editUser(Matchers.anyInt())).thenReturn(tempList);
		
		String str= controller.editEmployee("123",m);
		Assert.assertNotNull(str);
		Assert.assertEquals("edit", str);
	}
	
	
	
	@Test
	public void testeditEmployeeForFailure() throws Exception {
		Department dept = new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		List tempList = new ArrayList();
		tempList.add(empTest);
		Mockito.when(empService.editUser(Matchers.anyInt())).thenReturn(tempList);
		
		String str= controller.editEmployee("123",m);
		Assert.assertNotNull(str);
		Assert.assertEquals("editaaaa", str);
	}
	//to navigate to save page
	@Test
	public void testsaveEmployee() throws Exception {
		Department dept = new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);
		List tempList = new ArrayList();
		tempList.add(empTest);
		
		Mockito.when(empService.getDepartmentList()).thenReturn(tempList);
		ModelAndView modelAndView= controller.saveEmployee(empTest,result,m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertEquals("save", modelAndView.getViewName());
	}
	

	@Test
	public void testAddEmployee() throws Exception {

		Department dept = new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setDepartment(dept);

		Mockito.when(empService.addUsers(Matchers.any(Employee.class))).thenReturn(123);
		ModelAndView modelAndView = controller.addEmployee(empTest, result, m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertEquals("index", modelAndView.getViewName());
	}
	
	
	@Test
	public void testUpdateEmployee() throws Exception {

		Department dept = new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setEmail("ddddddd");
		empTest.setDepartment(dept);

		Mockito.doNothing().when(empService).updateUsers(Matchers.any(Employee.class));
		ModelAndView modelAndView=controller.updateEmployee(empTest, result, m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertEquals("index", modelAndView.getViewName());
	}
}
