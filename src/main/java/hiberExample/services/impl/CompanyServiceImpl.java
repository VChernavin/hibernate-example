package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hiberExample.dao.CompanyDao;
import hiberExample.models.Company;
import hiberExample.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public List<Company> getAll() {
		return companyDao.getAll();
	}

	@Cacheable(value = "company.byId", key = "#id", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Company get(Long id) {
		return companyDao.getById(id);
	}

	@Cacheable(value = "company.byName", key = "#name", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Company get(String name) {
		return companyDao.getByName(name);
	}

	public void create(Company company) {
		companyDao.create(company);
	}

	public void update(Company company) {
		companyDao.update(company);
	}

	public void delete(Long id) {
		companyDao.delete(id);
	}
}
