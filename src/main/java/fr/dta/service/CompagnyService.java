package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;

@Transactional
@Service
public class CompagnyService {
	@Autowired
	private EmployeeMockService employeeMockService;
	
	public List<Employee> findEmployees(){
		return employeeMockService.findAllEmployees();
	}

}
