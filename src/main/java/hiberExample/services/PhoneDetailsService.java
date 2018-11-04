package hiberExample.services;

import hiberExample.models.PhoneDetails;

import java.util.List;

public interface PhoneDetailsService {

	List<PhoneDetails> getAll();

	PhoneDetails get(Long id);

	PhoneDetails getByProvider(String provider);

	PhoneDetails getByTechnology(String technology);

	void create(PhoneDetails phoneDetails);

	PhoneDetails update(PhoneDetails phoneDetails);

	void delete(Long id);
}
