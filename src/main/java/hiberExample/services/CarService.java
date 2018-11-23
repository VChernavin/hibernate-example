package hiberExample.services;

import java.util.List;

import hiberExample.dto.CarDto;

public interface CarService {
	List<CarDto> getAll();

	List<CarDto> getByCompany(String name);

	CarDto get(Long id);

	void create(CarDto car);

	void update(CarDto car);

	void delete(Long id);
}
