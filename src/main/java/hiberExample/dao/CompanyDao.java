package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hiberExample.dto.CompanyBaseDto;
import hiberExample.dto.CompanyDto;
import hiberExample.models.Company;

@Repository
@Transactional
public class CompanyDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	public CompanyDto getById(long id) {
		return dozerBeanMapper.map(entityManager.find(Company.class, id), CompanyDto.class);
	}

	public CompanyBaseDto getBaseById(long id) {

			return dozerBeanMapper.map(entityManager.find(Company.class, id), CompanyBaseDto.class);
	}

	public CompanyDto getByName(String name) {

		return dozerBeanMapper.map(entityManager.createQuery("from Company where name = :name ")
				.setParameter("name", name).getSingleResult(),CompanyDto.class);
	}

	public List<Company> getAll() {

		return entityManager.createQuery("from Company").getResultList();
	}

	public void create(Company company) {
		entityManager.persist(company);
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
