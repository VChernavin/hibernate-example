package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberExample.dao.OfficeDao;
import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.models.Office;
import hiberExample.services.OfficeService;


@Service
public class OfficeServiceImpl  implements OfficeService {
	@Autowired
	private OfficeDao officeDao;

	public List<Office> getAll() {
		return officeDao.getAll();
	}

	public OfficeDto get(Long id) {
		return officeDao.getById(id);
	}

	public OfficeBaseDto getBase(Long id) {
		return officeDao.getBaseById(id);
	}


	public void create(Office office) {
		officeDao.create(office);
	}

	public void update(Office office) {
		officeDao.update(office);
	}

	public void delete(Long id) {
		officeDao.delete(id);
	}
}
