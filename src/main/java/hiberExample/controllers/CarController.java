package hiberExample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hiberExample.models.Car;
import hiberExample.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	List<Car> getAll() {
		return carService.getAll();
	}

	@GetMapping(value = "/filterByCompany")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	List<Car> getByCompany(String name) {
		return carService.getByCompany(name);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void create(@RequestBody Car car) {
		carService.create(car);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Car get(@PathVariable Long id) {
		return carService.get(id);
	}

	@PutMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@RequestBody Car car) {
		carService.update(car);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		carService.delete(id);
	}
}
