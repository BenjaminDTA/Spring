package fr.dta.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;

@Transactional
@Service
public class EmployeeJdbcService implements EmployeeService {
	private EmployeeRepository employeeJdbcRepository;

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}
}
