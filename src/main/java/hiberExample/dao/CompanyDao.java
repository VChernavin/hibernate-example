package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import hiberExample.models.Company;

@Repository
@Transactional
public class CompanyDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Cacheable(value = "company.byId", key = "#id", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Company getById(long id) {
		return entityManager.find(Company.class, id);
	}

	public Company getBaseById(long id) {

		return entityManager.find(Company.class, id);
	}

	@Cacheable(value = "company.byName", key = "#name", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Company getByName(String name) {

		return (Company) entityManager.createQuery("from Company where name = :name ")
				.setParameter("name", name).getSingleResult();
	}

	public List<Company> getAll() {

		return entityManager.createQuery("from Company").getResultList();
	}

	public void create(Company company) {
		entityManager.persist(company);
	}

	@Transactional
	public void create(List<Company> companies) {
		for (Company company : companies) {
			entityManager.persist(company);
		}
	}

	public void update(Company company) {
		entityManager.merge(company);
	}

	public void delete(long id) {
		Company company = entityManager.find(Company.class, id);
		if (company != null) {
			entityManager.remove(company);
		}
	}

}
