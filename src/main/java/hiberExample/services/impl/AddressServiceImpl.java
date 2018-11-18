package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberExample.dao.AddressDao;
import hiberExample.models.Address;
import hiberExample.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	public List<Address> getAll() {
		return addressDao.getAll();
	}

	public List<Address> getByCompany(String name) {
		return addressDao.getByCompany(name);
	}

	public Address get(Long id) {
		return addressDao.getById(id);
	}


	public void create(Address address) {
		addressDao.create(address);
	}

	public void update(Address address) {
		addressDao.update(address);
	}

	public void delete(Long id) {
		addressDao.delete(id);
	}
}
