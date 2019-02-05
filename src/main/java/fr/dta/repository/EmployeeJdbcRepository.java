package fr.dta.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.exception.UnknownEmployeeException;
import fr.dta.mapper.EmployeeMapper;
import fr.dta.modele.Employee;

@Repository
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {

	@Override
	public void saveEmployee(Employee employee) {
		this.getJdbcTemplate().update(
				"insert into employee (firstname, hiredate, lastname, salary, ssn) values(?,?,?,?,?)",
				employee.getPrenom(), new Date(), employee.getNomFamille(), 25000, employee.getSecuSocial());

	}

	@Override
	public List<Employee> findAllEmployees() {
		return this.getJdbcTemplate().query("select id, firstname, hiredate, lastname, salary, ssn from employee",
				new EmployeeMapper());

	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void updateAllEmployees(List<Employee> list) throws RuntimeException {
		for (Employee e : findAllEmployees()) {
			if (!list.contains(e)) {
				throw new UnknownEmployeeException("La Liste ne contient pas cet utilisateur");
			} else {
				saveEmployee(e);
			}
		}
	}

	public Employee findBySsn(String ssn) {
		Employee employee = this.getJdbcTemplate().queryForObject("select * from employee where ssn=?",
				new Object[] { ssn }, new RowMapper<Employee>() {
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
				});
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.getJdbcTemplate().update(
				"update employee set firstname= ?, lastname= ?, hiredate= ?, salary= ?, ssn= ? where id = ?",
				employee.getPrenom(), employee.getNomFamille(),
				Date.from(employee.getDateEmbauche().atStartOfDay(ZoneId.systemDefault()).toInstant()),
				employee.getSalaire(), employee.getSecuSocial(), employee.getId());
	}

	@Override
	public void deleteAll() {
		this.getJdbcTemplate().update("delete from employee");
	}

}
