package com.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Department;
import com.model.Employee;

@Repository
public class DaoImpl implements Dao {  

	@Autowired
	private SessionFactory sessionFactory;


	public Employee searchEmployeeById(int id) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("id", id));
		
		Object obj = cr.uniqueResult();
        Employee emp =(Employee)obj; 
		
		
		session.close();
		return emp;
	}

	public List<Employee> findAllUsers() {

		// fetchAllDetails();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		// cr.add(Restrictions.eq("id", 1));
		// List results = cr.list();
		List<Employee> emp = (List<Employee>) cr.list();
//		session.close();

		return emp;
	}

	public int addUsers(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		Department dpt = emp.getDepartment();
		//Transaction t = session.beginTransaction();
		session.save(emp);
		//t.commit();
		//session.close();
		System.out.println("id in dao is : "+ emp.getId());
		return emp.getId();

	}

	public int deleteUser(int id) {
		System.out.println("In delete user method......");
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("delete from Employee where id=:id");
		q.setInteger("id", id);
		int result = q.executeUpdate();
		//t.commit();
		//session.close();
		return result;
	}

	//editUser selects the user based on id and populates the edit page
	public List<Employee> editUser(int id) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("id", id));
		
		List<Employee> emp = (List<Employee>) cr.list();
		session.close();
		return emp;
	}

	//updateUsers updates the employee data once it is entered on edit page
	public void updateUsers(Employee emp) {
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		//Transaction t = session.beginTransaction();
		session.update(emp);
		//t.commit();
		//session.close();
	}

	public List fetchAllDetails() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		List employee = session.createQuery("from Employee order by id asc").list();
		session.close();
		return employee; 
	}

	public List getDepartmentList() {

		Session session = sessionFactory.openSession();
		List deptList = session.createQuery("from Department").list();

		session.close();
		return deptList;
	}

	public int getDepartmentDetails(String deptName) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Department.class);
		cr.add(Restrictions.eq("name", deptName));
		List<Department> deptList = (List<Department>) cr.list();

		Iterator iter = deptList.iterator();
		int deptId = 0;
		while (iter.hasNext()) {
			Department dept = (Department) iter.next();
			deptId = dept.getDid();
		}

		return deptId;
	}
}
