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

import hiberExample.models.Department;
import hiberExample.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	private final DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping

	public @ResponseBody
	List<Department> getAll() {
		return departmentService.getAll();
	}

	@GetMapping(value = "/{id}")

	public @ResponseBody
	Department get(@PathVariable Long id) {
		return departmentService.get(id);
	}

	@GetMapping(value = "/filter")

	public @ResponseBody
	Department get(@RequestParam String name) {
		return departmentService.get(name);
	}

	@PostMapping

	public void create(@RequestBody Department department) {
		departmentService.create(department);
	}

	@PutMapping

	public void update(@RequestBody Department department) {
		departmentService.update(department);
	}

	@DeleteMapping(value = "/{id}")

	public void delete(@PathVariable Long id) {
		departmentService.delete(id);
	}
}
