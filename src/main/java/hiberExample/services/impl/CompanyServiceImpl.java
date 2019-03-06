package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberExample.dao.CompanyDao;
import hiberExample.dto.CompanyBaseDto;
import hiberExample.dto.CompanyDto;
import hiberExample.helper.DozerHelper;
import hiberExample.models.Company;
import hiberExample.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyDao companyDao;
	private final DozerHelper dozerHelper;

	@Autowired
	public CompanyServiceImpl(CompanyDao companyDao, DozerHelper dozerHelper) {
		this.companyDao = companyDao;
		this.dozerHelper = dozerHelper;
	}

	@Override
	public List<CompanyDto> getAll() {
		return dozerHelper.mapList( companyDao.getAll(),CompanyDto.class);
	}

	@Override
	public CompanyDto get(Long id) {
		return dozerHelper.map(companyDao.getById(id), CompanyDto.class);
	}

	@Override
	public CompanyBaseDto getBase(Long id) {
		return dozerHelper.map(companyDao.getBaseById(id),CompanyBaseDto.class);
	}

	@Override
	public CompanyDto get(String name) {
		return dozerHelper.map( companyDao.getByName(name),CompanyDto.class);
	}

	@Override
	public void create(CompanyDto company) {
		companyDao.create(dozerHelper.map(company, Company.class));
	}

	@Override
	public void create(List<CompanyDto> companies){
		companyDao.create(dozerHelper.mapList(companies, Company.class));
	}

	@Override
	public void update(CompanyDto company) {
		companyDao.update(dozerHelper.map(company, Company.class));
	}

	@Override
	public void delete(Long id) {
		companyDao.delete(id);
	}
}
