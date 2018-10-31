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

import hiberExample.models.Company;
import hiberExample.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping

	public @ResponseBody
	List<Company> getAll() {
		return companyService.getAll();
	}

	@GetMapping(value = "/{id}")

	public @ResponseBody
	Company get(@PathVariable Long id) {
		return companyService.get(id);
	}

	@GetMapping(value = "/filter")

	public @ResponseBody
	Company get(@RequestParam String name) {
		return companyService.get(name);
	}

	@PostMapping

	public void create(@RequestBody Company company) {
		companyService.create(company);
	}

	@PutMapping

	public void update(@RequestBody Company company) {
		companyService.update(company);
	}

	@DeleteMapping(value = "/{id}")

	public void delete(@PathVariable Long id) {
		companyService.delete(id);
	}

}