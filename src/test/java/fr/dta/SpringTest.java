package fr.dta;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeMockRepository;
import fr.dta.service.CompagnyService;
import fr.dta.service.EmployeeMockService;

public class SpringTest {
	
	@Test
	public void testSpringTest() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeMockRepository test = (EmployeeMockRepository) context.getBean("employeeMockRepository");
		assertNotNull(test);
		
		EmployeeMockService test1 = (EmployeeMockService) context.getBean("employeeMockService");
		Employee e1 = test1.findLastHired();
		assertEquals(e1.getId(), new Long(542));
		
		CompagnyService test2 = (CompagnyService) context.getBean("compagnyService");
		List<Employee> list = test2.findEmployees();
		assertNotNull(test2);
		
	}
}
