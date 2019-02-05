package fr.dta.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.exception.UnknownEmployeeException;
import fr.dta.modele.Employee;
import fr.dta.modele.Entreprise;

@Repository
@Transactional
public class EmployeeJpaRepository extends AbstractJpaRepository<Employee> implements EmployeeRepository {

	@Override
	protected Class<Employee> getEntityClass() {
		return Employee.class;
	}

	@Transactional(readOnly = true)
	public Optional<Employee> findOneByLogin(String login) {
		Employee employee = (Employee) getSession().createCriteria(entityClass).add(Restrictions.eq("login", login))
				.uniqueResult();
		return Optional.of(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllByCompany(Entreprise entreprise) {
		return getSession().createCriteria(entityClass).add(Restrictions.eq("entreprise", entreprise)).list();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.save(employee);

	}

	@Override
	public List<Employee> findAllEmployees() {
		return findAll();
	}

	@Override
	public Employee findBySsn(String ssn) {
		TypedQuery<Employee> employeeSsn = em.createQuery("select e from Employee e where e.secuSocial = :numSecu",Employee.class);
		return employeeSsn.setParameter("numSecu", ssn).getSingleResult();
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.update(employee);

	}

	@Override
	public void updateAllEmployees(List<Employee> list) {
		for (Employee e : findAllEmployees()) {
			if (!list.contains(e)) {
				throw new UnknownEmployeeException("La Liste ne contient pas cet utilisateur");
			} else {
				saveEmployee(e);
			}
		}
	}

	@Override
	public void deleteAll() {
		em.createQuery("Delete from Employee").executeUpdate();
	}
}