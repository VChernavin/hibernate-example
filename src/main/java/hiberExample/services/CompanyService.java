package hiberExample.services;

import java.util.List;

import hiberExample.models.Company;

public interface CompanyService {

	List<Company> getAll();

	Company get(Long id);

	Company get(String name);

	void create(Company company);

	void update(Company company);

	void delete(Long id);
}
