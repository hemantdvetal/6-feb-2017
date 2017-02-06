package com.dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;
import com.model.Department;
import com.model.Employee;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(MockitoJUnitRunner.class)
public class DaoImplTest {
     
	@Mock
    public SessionFactory sessionFactory ;
    @Mock
     public Session session;
    @Mock
     Criteria criteria;

    @InjectMocks
    public DaoImpl daoImpl = new DaoImpl();
    
    
  @Test
    public void findAllUsersTest(){
	  Department dept=new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setId(123);
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setEmail("xcvxcv");
		empTest.setDepartment(dept);
		
		List<Employee>list = new ArrayList();
		list.add(empTest);
    	Mockito.when(sessionFactory.openSession()).thenReturn(session);
    	Mockito.when(session.createCriteria(Employee.class)).thenReturn(criteria);
    	Mockito.when(daoImpl.findAllUsers()).thenReturn(list);
		List emp  = daoImpl.findAllUsers();
		Assert.assertNotNull(emp);
		
    	
    	
    	
    	
    }
	
	/*@Test
	public void testAddUsers() {
		
		Department dept=new Department();
		dept.setDid(123);
		Employee empTest = new Employee();
		empTest.setId(123);
		empTest.setFname("dfgdf");
		empTest.setLname("dfgd");
		empTest.setDob(new Date());
		empTest.setAddress("xcvxcv");
		empTest.setEmail("xcvxcv");
		empTest.setDepartment(dept);
		
		Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
		//sessionFactory = Mockito.spy(new SessionFactory());
		int id = daoImpl.addUsers(empTest);
	    Assert.assertTrue(id>0);
		
	}
*/
	

}
