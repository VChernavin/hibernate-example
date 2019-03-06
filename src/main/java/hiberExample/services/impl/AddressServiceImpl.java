package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberExample.dao.AddressDao;
import hiberExample.dto.AddressDto;
import hiberExample.helper.DozerHelper;
import hiberExample.models.Address;
import hiberExample.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	private final AddressDao addressDao;
	private final DozerHelper dozerHelper;

	@Autowired
	public AddressServiceImpl(AddressDao addressDao, DozerHelper dozerHelper) {
		this.addressDao = addressDao;
		this.dozerHelper = dozerHelper;
	}

	public List<AddressDto> getAll() {
		return dozerHelper.mapList(addressDao.getAll(), AddressDto.class);
	}

	public AddressDto get(Long id) {
		return dozerHelper.map(addressDao.getById(id), AddressDto.class);
	}

	@Override
	public void create(AddressDto address) {
		addressDao.create(dozerHelper.map(address, Address.class));
	}

	@Override
	public void create(List<AddressDto> companies) {
		addressDao.create(dozerHelper.mapList(companies, Address.class));
	}

	@Override
	public void update(AddressDto address) {
		addressDao.update(dozerHelper.map(address,Address.class));
	}

	@Override
	public void delete(Long id) {
		addressDao.delete(id);
	}
}
