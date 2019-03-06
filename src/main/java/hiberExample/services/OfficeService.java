package hiberExample.services;

import java.util.List;

import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.models.Office;

public interface OfficeService {
	List<OfficeDto> getAll();

	OfficeDto get(Long id);

	OfficeBaseDto getBase(Long id);

	void create(OfficeDto office);

	void create(List<OfficeDto> office);

	void update(OfficeDto office);

	void delete(Long id);
}
