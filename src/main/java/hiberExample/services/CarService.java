package hiberExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hiberExample.dao.CarDao;
import hiberExample.models.Car;

public class CarService {

	@Autowired
	CarDao carDao;

	public List<Car> getAll() {
		return carDao.getAll();
	}

	public List<Car> getByCompany(String name) {
		return carDao.getByCompany(name);
	}

	public Car get(Long id) {
		return carDao.getById(id);
	}

	public void create(Car car) {
		carDao.create(car);
	}

	public void update(Car car) {
		carDao.update(car);
	}

	public void delete(Long id) {
		carDao.delete(id);
	}

}
