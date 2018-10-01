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
}
