package fr.dta.repository;

import java.util.List;

import fr.dta.modele.Employee;

public interface EmployeeRepository{
	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);

	void updateAllEmployees(List<Employee> list);

	void deleteAll();
	
	
}
