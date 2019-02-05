package fr.dta.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;

@Transactional
public interface EmployeeService {
	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);

	Employee findLastHired();

}
