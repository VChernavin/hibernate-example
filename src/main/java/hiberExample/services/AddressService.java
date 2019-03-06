package hiberExample.services;

import java.util.List;

import hiberExample.dto.AddressDto;
import hiberExample.models.Address;

public interface AddressService {
	List<AddressDto> getAll();

	AddressDto get(Long id);


	void create(AddressDto address);

	void create(List<AddressDto> companies);

	void update(AddressDto address);

	void delete(Long id);
}
