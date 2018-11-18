package hiberExample.services;

import java.util.List;

import hiberExample.models.Address;

public interface AddressService {
	List<Address> getAll();

	Address get(Long id);


	void create(Address address);

	void update(Address address);

	void delete(Long id);
}
