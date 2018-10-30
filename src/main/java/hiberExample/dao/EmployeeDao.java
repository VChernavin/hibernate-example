package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hiberExample.models.Employee;

@Repository
@Transactional
public class EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Employee getById(long id) {
		return entityManager.find(Employee.class, id);
	}

	public Employee getByName(String name) {

		return (Employee) entityManager.createQuery("from Employee where name = :name ")
				.setParameter("name", name).getSingleResult();
	}

	public Employee getBySurname(String surname) {

		return (Employee) entityManager.createQuery("from Employee where surname = :surname ")
				.setParameter("surname", surname).getSingleResult();
	}

	public List<Employee> getAll() {

		return entityManager.createQuery("from Employee").getResultList();
	}

	public void create(Employee employee) {
		entityManager.persist(employee);
	}

	public Employee update(Employee employee) {
		return  entityManager.merge(employee);
	}

	public void delete(long id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityManager.remove(employee);
		}
	}
}
