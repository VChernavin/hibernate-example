package hiberExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hiberExample.dao.PhoneDetailsDao;
import hiberExample.models.PhoneDetails;

@Service
public class PhoneDetailsService {
	@Autowired
	private PhoneDetailsDao phoneDetailsDao;

	public List<PhoneDetails> getAll() {
		return phoneDetailsDao.getAll();
	}

	@Cacheable(value = "phoneDetails.byId", key = "#id", unless = "#result != null and #result.provider.toUpperCase().startsWith('TEST')")
	public PhoneDetails get(Long id) {
		return phoneDetailsDao.getById(id);
	}

	@Cacheable(value = "phoneDetails.byProvider", key = "#provider", unless = "#result != null and #result.provider.toUpperCase().startsWith('TEST')")
	public PhoneDetails getByProvider(String provider) {
		return phoneDetailsDao.getByProvider(provider);
	}

	@Cacheable(value = "phoneDetails.byProvider", key = "#technology", unless = "#result != null and #result.provider.toUpperCase().startsWith('TEST')")
	public PhoneDetails getByTechnology(String technology) {
		return phoneDetailsDao.getByTechnology(technology);
	}

	public void create(PhoneDetails phoneDetails) {
		phoneDetailsDao.create(phoneDetails);
	}

	public PhoneDetails update(PhoneDetails phoneDetails) {
		return phoneDetailsDao.update(phoneDetails);
	}

	public void delete(Long id) {
		phoneDetailsDao.delete(id);
	}
}
