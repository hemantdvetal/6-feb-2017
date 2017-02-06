package com.junit;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.controller.HelloWorldController;
import com.dao.DaoImpl;
import com.model.Department;
import com.model.Employee;
import com.service.EmpServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {
	@InjectMocks
	HelloWorldController contrioller = new HelloWorldController();

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
		ModelAndView modelAndView = contrioller.fetchEmployee(empTest, result, m);
		Assert.assertNotNull(modelAndView);
		Assert.assertNotNull(modelAndView.getViewName());
		Assert.assertEquals("index", modelAndView.getViewName());
	}

}
