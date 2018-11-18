package hiberExample.services;

import java.util.List;

import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.models.Office;

public interface OfficeService {
	List<Office> getAll();

	OfficeDto get(Long id);

	OfficeBaseDto getBase(Long id);

	void create(Office office);

	void update(Office office);

	void delete(Long id);
}
