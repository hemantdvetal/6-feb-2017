package com.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.editor.DepartmentEditor;
import com.model.Department;
import com.model.Employee;
import com.service.EmpService;
import com.service.EmpServiceImpl;

@Controller
@RequestMapping("save.do")
public class HelloWorldController { 
	
	@Autowired
	 EmpService empServiceimpl;
	
	@InitBinder	
	public void initBinder(WebDataBinder binder) {
		// binder.addValidators(emailValidator,customerValidator);
		binder.registerCustomEditor(Department.class, new DepartmentEditor());
		/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(
				dateFormat, true));*/
	}
	
	//search employee by ID
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "search", method = RequestMethod.POST)
	public ModelAndView fetchEmployee(@ModelAttribute("employee") Employee emp,BindingResult result, Model m) {
		Employee employee = empServiceimpl.searchEmployeeById(emp.getId());

		@SuppressWarnings("rawtypes")
		List employeeList = new ArrayList();
		employeeList.add(employee);

		return new ModelAndView("index", "employee1", employeeList);

	} 

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@RequestParam("checkbox") String empid,
			Model m) {

		int id = Integer.parseInt(empid);
		int idForDelete = empServiceimpl.deleteUser(id);
		@SuppressWarnings("rawtypes")
		List emp = empServiceimpl.fetchAllDetails();
		m.addAttribute("lists", emp);
		return new ModelAndView("index");
	}
 
	@RequestMapping(params = "save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(
			@ModelAttribute("employee") Employee employee,
			BindingResult result, Model m) {

		@SuppressWarnings("rawtypes")
		List deptList = empServiceimpl.getDepartmentList();
		m.addAttribute("deptList", deptList); 
		m.addAttribute("employee", employee);

		return new ModelAndView("save");
	}

	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String editEmployee(@RequestParam("checkbox") String empid, Model m)
			throws ParseException {

		int id = Integer.parseInt(empid);

		List<Employee> emp = empServiceimpl.editUser(id);
		Employee emp1 = emp.get(0);

		@SuppressWarnings("rawtypes")
		List deptList = empServiceimpl.getDepartmentList();

		m.addAttribute("employee", emp1);
		m.addAttribute("deptList", deptList);
		return "edit";

	}

	@RequestMapping(params = "back", method = RequestMethod.POST)
	public ModelAndView backToMainPage(
			@ModelAttribute("employee") Employee employee, BindingResult result) {

		@SuppressWarnings("unchecked")
		List<Employee> emp = empServiceimpl.fetchAllDetails();
		// m.addAttribute("emp", emp);
		return new ModelAndView("index", "employee", emp);
	}

	@RequestMapping(params = "saveEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(
			@ModelAttribute("employee") Employee employee,
			BindingResult result, Model m) {
		
		
		/*emailValidator.validate(employee.getEmail(), result);
		customerValidator.validate(employee, result);
		*/

		employee.setCreateddate(new Timestamp(new Date().getTime()));
		employee.setModifieddate(new Timestamp(new Date().getTime()));
		int empId = empServiceimpl.addUsers(employee);
		System.out.println("Employee id after save is " + empId);
		String message = "Employee: " + empId + " has been added successfully";
		/*
		 * @SuppressWarnings("unchecked") List<Employee> lists =
		 * service.fetchAllDetails(); m.addAttribute("lists", lists);
		 */
		return new ModelAndView("index", "message", message);
	}

	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(
			@ModelAttribute("employee") Employee employee,
			BindingResult result, Model m) {
		boolean error = false;
		if (employee.getFname().isEmpty()) {
			result.rejectValue("fname", "error.fname");
			error = true;
		}
		if (employee.getLname().isEmpty()) {
			result.rejectValue("lname", "error.lname");
			error = true;
		}
		if (employee.getDob() == null) {
			// String dob = dateOfBirth;
			System.out.println("DOB is nulll........");
			result.rejectValue("dob", "error.dob");
			error = true;
		}
		if (employee.getAddress().isEmpty()) {
			result.rejectValue("address", "error.address");
			error = true;
		}
		if (employee.getEmail().isEmpty()) {
			result.rejectValue("email", "error.email");
			error = true;
		 }

		if (error) {
			List<Employee> emp = empServiceimpl.editUser(employee.getId());
			@SuppressWarnings("rawtypes")
			List deptList = empServiceimpl.getDepartmentList();
			m.addAttribute("deptList", deptList);
			m.addAttribute("lists", emp);
			return new ModelAndView("edit");
		}

		employee.setCreateddate(new Timestamp(new Date().getTime()));
		employee.setModifieddate(new Timestamp(new Date().getTime()));

		empServiceimpl.updateUsers(employee);
		@SuppressWarnings("unchecked")
		List<Employee> emp = empServiceimpl.fetchAllDetails();
		m.addAttribute("lists", emp);
		return new ModelAndView("index");
	}

}
