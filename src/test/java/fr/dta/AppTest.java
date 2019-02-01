package fr.dta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeJdbcRepository;
import fr.dta.service.MailService;

public class AppTest {
	
	@Test
	public void testService() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		MailService mailServiceA = (MailService) context.getBean("mailService");
		mailServiceA.setMessage("you got mail !");
		MailService mailServiceB = (MailService) context.getBean("mailService");
		mailServiceB.setMessage("you got E-mail !");
		
		Employee e1 = new Employee(new Long(543), "Maurice", "Lafondue", "0102030405", new BigDecimal(1500.00), LocalDate.of(2019, Month.JANUARY, 6));
		mailServiceA.sendMail(e1);
		mailServiceB.sendMail(e1);
	}
	@Test
	public void testSaveEmployee() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeJdbcRepository test = (EmployeeJdbcRepository) context.getBean("employeeJdbcRepository");
		Employee e2 = new Employee(new Long(543), "Maurice", "Lafondue", "0102030405", new BigDecimal(1500.00), LocalDate.of(2019, Month.JANUARY, 6));
		Employee e3 = new Employee(new Long(541), "Bebere", "Lafondue", "0202030405", new BigDecimal(1500.00), LocalDate.of(2019, Month.JANUARY, 8));
		Employee e4 = new Employee(new Long(542), "Jeannots", "Lafondue", "0302030405", new BigDecimal(1500.00), LocalDate.of(2019, Month.JANUARY, 12));
		test.saveEmployee(e2);
		test.saveEmployee(e3);
		test.saveEmployee(e4);
	}
	
	@Test
	public void testUpdateEmployee() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeJdbcRepository test = (EmployeeJdbcRepository) context.getBean("employeeJdbcRepository");
		Employee e3 = new Employee(new Long(541), "Bebertus", "DeLafondux", "0202030405", new BigDecimal(1500.00), LocalDate.of(2019, Month.JANUARY, 8));
		test.updateEmployee(e3);
	}
	
	@Test
	public void testFindAllEmployees() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeJdbcRepository test = (EmployeeJdbcRepository) context.getBean("employeeJdbcRepository");
		test.findAllEmployees();
	}
	@Test
	public void testFindBySsn() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeJdbcRepository test = (EmployeeJdbcRepository) context.getBean("employeeJdbcRepository");
		test.findBySsn("0302030405");
	}
		
	@Test
	public void testUpdateAllEmployees() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		EmployeeJdbcRepository test = (EmployeeJdbcRepository) context.getBean("employeeJdbcRepository");
		Employee e3 = new Employee(new Long(541), "Bebertus", "DeLafondux", "0202030405", new BigDecimal(1500.00), LocalDate.of(2019, Month.JANUARY, 8));
		List<Employee> list = new ArrayList<Employee>();
		test.updateAllEmployees(list);
	}
		
		
		
	}

