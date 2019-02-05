package fr.dta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
	EmployeeService employeeJdbcService;

	public void start() {
		employeeJdbcService.findAllEmployees();
	}

}
