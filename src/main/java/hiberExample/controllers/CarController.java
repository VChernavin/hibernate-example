package hiberExample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hiberExample.dto.CarDto;
import hiberExample.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping

	public @ResponseBody
	List<CarDto> getAll() {
		return carService.getAll();
	}

	@GetMapping(value = "/filterByCompany")

	public @ResponseBody
	List<CarDto> getByCompany(String name) {
		return carService.getByCompany(name);
	}

	@PostMapping

	public void create(@RequestBody CarDto car) {
		carService.create(car);
	}

	@GetMapping(value = "/{id}")

	public @ResponseBody
	CarDto get(@PathVariable Long id) {
		return carService.get(id);
	}

	@PutMapping

	public void update(@RequestBody CarDto car) {
		carService.update(car);
	}

	@DeleteMapping(value = "/{id}")

	public void delete(@PathVariable Long id) {
		carService.delete(id);
	}
}
