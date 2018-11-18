package hiberExample.services;

import java.util.List;

import hiberExample.dto.CompanyBaseDto;
import hiberExample.dto.CompanyDto;
import hiberExample.models.Company;

public interface CompanyService {

	List<Company> getAll();

	CompanyDto get(Long id);

	CompanyBaseDto getBase(Long id);

	CompanyDto get(String name);

	void create(Company company);

	void update(Company company);

	void delete(Long id);
}
