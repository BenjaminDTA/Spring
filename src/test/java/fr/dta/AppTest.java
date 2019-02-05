package fr.dta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.dta.exception.UnknownEmployeeException;
import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;
import fr.dta.service.EmployeeService;
import fr.dta.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class AppTest {

	@Autowired
	MailService mailServiceA;

	@Autowired
	MailService mailServiceB;

	@Autowired
	EmployeeRepository employeeJpaRepository;

	@Autowired
	EmployeeService employeeJdbcService;

	@Before
	public void before() {
		Employee e2 = new Employee("Maurice", "Lafondue", "0102030402", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 6));
		employeeJpaRepository.saveEmployee(e2);
	}

	@After
	public void after() {
		employeeJpaRepository.deleteAll();
	}

	@Test
	public void testService() {
		mailServiceA.setMessage("you got mail !");
		mailServiceB.setMessage("you got E-mail !");
		Employee e1 = new Employee("Maurice", "Lafondue", "0102030401", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 6));
		mailServiceA.sendMail(e1);
		mailServiceB.sendMail(e1);
	}

	@Test
	public void testSaveEmployee() {
		Employee e2 = new Employee("Maurice", "Lafondue", "0102030402", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 6));
		Employee e3 = new Employee("Bebere", "Lafondue", "0202030403", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 8));
		Employee e4 = new Employee("Jeannots", "Lafondue", "0302030404", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 12));
		employeeJpaRepository.saveEmployee(e2);
		employeeJpaRepository.saveEmployee(e3);
		employeeJpaRepository.saveEmployee(e4);
	}

	@Test
	public void testUpdateEmployee() {
		Employee e3 = new Employee("Bebertus", "DeLafondux", "0202030405", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 8));
		employeeJpaRepository.updateEmployee(e3);
	}

	@Test
	public void testFindAllEmployees() {
		employeeJpaRepository.findAllEmployees();
	}

	@Test
	public void testFindBySsn() {
		employeeJpaRepository.findBySsn("0102030402");
	}

	@Test(expected = UnknownEmployeeException.class)
	public void testUpdateAllEmployees() {
		Employee e3 = new Employee("Bebertus", "DeLafondux", "0202030406", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 8));
		List<Employee> list = new ArrayList<Employee>();
		employeeJpaRepository.updateAllEmployees(list);
	}

}
