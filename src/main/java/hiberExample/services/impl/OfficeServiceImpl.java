package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberExample.dao.OfficeDao;
import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.helper.DozerHelper;
import hiberExample.models.Office;
import hiberExample.services.OfficeService;


@Service
public class OfficeServiceImpl  implements OfficeService {

	private final OfficeDao officeDao;
	private final DozerHelper dozerHelper;

	@Autowired
	public OfficeServiceImpl(OfficeDao officeDao,DozerHelper dozerHelper) {
		this.officeDao = officeDao;
		this.dozerHelper = dozerHelper;
	}

	@Override
	public List<OfficeDto> getAll() {
		return dozerHelper.mapList( officeDao.getAll(),OfficeDto.class);
	}

	@Override
	public OfficeDto get(Long id) {
		return dozerHelper.map(officeDao.getById(id),OfficeDto.class);
	}

	@Override
	public OfficeBaseDto getBase(Long id) {
		return dozerHelper.map(officeDao.getById(id),OfficeBaseDto.class);
	}


	@Override
	public void create(OfficeDto office) {
		officeDao.create(dozerHelper.map(office,Office.class));
	}

	@Override
	public void create(List<OfficeDto> office) {
		officeDao.create(dozerHelper.mapList(office,Office.class));
	}

	@Override
	public void update(OfficeDto office) {
		officeDao.update(dozerHelper.map(office,Office.class));
	}

	@Override
	public void delete(Long id) {
		officeDao.delete(id);
	}
}
