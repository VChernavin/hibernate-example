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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hiberExample.models.Employee;
import hiberExample.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping

	public @ResponseBody
	List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping(value = "/{id}")

	public @ResponseBody
	Employee get(@PathVariable Long id) {
		return employeeService.get(id);
	}

	@GetMapping(value = "/filter")

	public @ResponseBody
	Employee get(@RequestParam String name) {
		return employeeService.get(name);
	}

	@PostMapping

	public void create(@RequestBody Employee employee) {
		employeeService.create(employee);
	}

	@PutMapping

	public void update(@RequestBody Employee employee) {
		employeeService.update(employee);
	}

	@DeleteMapping(value = "/{id}")

	public void delete(@PathVariable Long id) {
		employeeService.delete(id);
	}
}
