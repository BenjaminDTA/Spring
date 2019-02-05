package fr.dta.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import fr.dta.modele.Employee;

@Repository
public class EmployeeMockRepository implements EmployeeRepository {

	private List<Employee> listEmployee;

	public EmployeeMockRepository() {
		listEmployee = new ArrayList<Employee>();
	}

	@PostConstruct // la méthod initList sera lancée apres le constructeur
	public void initList() {
		Employee e1 = new Employee("Benjamin", "Montet", "0504010203", new BigDecimal(2100.00),
				LocalDate.of(2019, Month.JANUARY, 19));
		Employee e2 = new Employee("Maurice", "Lafondue", "0102030405", new BigDecimal(1500.00),
				LocalDate.of(2019, Month.JANUARY, 6));
		Employee e3 = new Employee("Roberto", "Robert", "0201030405", new BigDecimal(2100.00),
				LocalDate.of(2019, Month.JANUARY, 18));
		Employee e4 = new Employee("Jean", "Delabatte", "0405010203", new BigDecimal(2100.00),
				LocalDate.of(2019, Month.JANUARY, 11));
		listEmployee.add(e1);
		listEmployee.add(e2);
		listEmployee.add(e3);
		listEmployee.add(e4);

	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	public List<Employee> findAllEmployees() {
		return listEmployee;
	}

	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAllEmployees(List<Employee> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
