package hiberExample.services;

import java.util.List;

import hiberExample.dto.CompanyBaseDto;
import hiberExample.dto.CompanyDto;
import hiberExample.models.Company;

public interface CompanyService {

	List<CompanyDto> getAll();

	CompanyDto get(Long id);

	CompanyBaseDto getBase(Long id);

	CompanyDto get(String name);

	void create(CompanyDto company);

	void create(List<CompanyDto> companies);

	void update(CompanyDto company);

	void delete(Long id);
}
