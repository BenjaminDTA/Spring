package fr.dta.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeMockRepository;

@Transactional
@Service
public class EmployeeMockService implements EmployeeService {
	
	@Autowired
	private EmployeeMockRepository emr;
	
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	public Employee findLastHired() {
		return emr.findAllEmployees().stream().max(Comparator.comparing(Employee::getDateEmbauche)).get();
		
	}

}
