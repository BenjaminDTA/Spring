package fr.dta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;
import fr.dta.service.CompagnyService;
import fr.dta.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class SpringTest {

	@Autowired
	EmployeeRepository employeeMockRepository;

	@Autowired
	EmployeeService employeeMockService;

	@Autowired
	CompagnyService compagnyService;

	@Test
	public void testSpringTest() {
		assertNotNull(employeeMockRepository);

		Employee e1 = employeeMockService.findLastHired();
		assertEquals(e1.getId(), new Long(542));

		List<Employee> list = compagnyService.findEmployees();
		assertNotNull(compagnyService);

	}
}
