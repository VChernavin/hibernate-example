package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiberExample.dao.CarDao;
import hiberExample.dto.CarDto;
import hiberExample.helper.DozerHelper;
import hiberExample.models.Car;
import hiberExample.services.CarService;

@Service
public class CarServiceImpl implements CarService {

	private final CarDao carDao;

	private final DozerHelper dozerHelper;

	@Autowired
	public CarServiceImpl(DozerHelper dozerHelper, CarDao carDao) {
		this.dozerHelper = dozerHelper;
		this.carDao = carDao;
	}

	@Override
	public List<CarDto> getAll() {
		return dozerHelper.mapList(carDao.getAll(),CarDto.class);
	}

	@Override
	public List<CarDto> getByCompany(String name) {
		return dozerHelper.mapList(carDao.getByCompany(name),CarDto.class);
	}

	@Override
	public CarDto get(Long id) {
		return dozerHelper.map(carDao.getById(id) ,CarDto.class);
	}

	@Override
	public void create(CarDto car) {
		carDao.create(dozerHelper.map(car,Car.class));
	}

	@Override
	public void update(CarDto car) {
		carDao.update(dozerHelper.map(car,Car.class));
	}

	@Override
	public void delete(Long id) {
		carDao.delete(id);
	}

}
