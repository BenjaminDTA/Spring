package fr.dta.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.repository.EmployeeJdbcRepository;
@Transactional
@Service
public class EmployeeJdbcService {
	private EmployeeJdbcRepository employeeJdbcRepository;
}
