package fr.dta.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.dta.modele.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getLong("id"));
		employee.setPrenom(rs.getString("firstname"));
		employee.setNomFamille(rs.getString("lastname"));
		employee.setSecuSocial(rs.getString("ssn"));
		employee.setSalaire(rs.getBigDecimal("salary"));
		employee.setDateEmbauche(rs.getTimestamp("hiredate").toLocalDateTime().toLocalDate());
		return employee;
	}
}