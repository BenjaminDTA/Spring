package fr.dta.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;
@Transactional
@Service
public class EmployeeJpaService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeJpaRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeJpaRepository.saveEmployee(employee);;
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeJpaRepository.findAllEmployees();
	}

	@Override
	public Employee findBySsn(String ssn) {
		return employeeJpaRepository.findBySsn(ssn);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeJpaRepository.updateEmployee(employee);

	}

	@Override
	public Employee findLastHired() {
		return employeeJpaRepository.findAllEmployees().stream().max(Comparator.comparing(Employee::getDateEmbauche))
				.get();
	}

}
