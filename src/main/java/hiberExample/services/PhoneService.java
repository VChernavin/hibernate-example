package hiberExample.services;

import java.util.List;

import hiberExample.models.Phone;

public interface PhoneService {
	List<Phone> getAll();

	Phone get(Long id);

	Phone getByNumber(String number);

	void create(Phone phone);

	Phone update(Phone phone);

	void delete(Long id);
}
