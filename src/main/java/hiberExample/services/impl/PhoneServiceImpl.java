package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hiberExample.dao.PhoneDao;
import hiberExample.models.Phone;
import hiberExample.services.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDao phoneDao;

	public List<Phone> getAll() {
		return phoneDao.getAll();
	}

	@Cacheable(value = "phone.byId", key = "#id", unless = "#result != null and #result.details.provider.toUpperCase().startsWith('TEST')")
	public Phone get(Long id) {
		return phoneDao.getById(id);
	}

	@Cacheable(value = "phone.byProvider", key = "#number", unless = "#result != null and #result.details.provider.toUpperCase().startsWith"
			+ "('TEST')")
	public Phone getByNumber(String number) {
		return phoneDao.getByNumber(number);
	}

	public void create(Phone phone) {
		phoneDao.create(phone);
	}

	public Phone update(Phone phone) {
		return phoneDao.update(phone);
	}

	public void delete(Long id) {
		phoneDao.delete(id);
	}
}
