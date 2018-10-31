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

import hiberExample.models.PhoneDetails;
import hiberExample.services.PhoneDetailsService;

@RestController
@RequestMapping("/phoneDetails")
public class PhoneDetailsController {

	@Autowired
	private PhoneDetailsService phoneDetailsService;

	@GetMapping

	public @ResponseBody
	List<PhoneDetails> getAll() {
		return phoneDetailsService.getAll();
	}

	@GetMapping(value = "/{id}")

	public @ResponseBody
	PhoneDetails get(@PathVariable Long id) {
		return phoneDetailsService.get(id);
	}

	@GetMapping(value = "/provider")

	public @ResponseBody
	PhoneDetails getByProvider(@RequestParam String provider) {
		return phoneDetailsService.getByProvider(provider);
	}

	@GetMapping(value = "/technology")

	public @ResponseBody
	PhoneDetails getByTechnology(@RequestParam String technology) {
		return phoneDetailsService.getByTechnology(technology);
	}

	@PostMapping

	public void create(@RequestBody PhoneDetails phoneDetails) {
		phoneDetailsService.create(phoneDetails);
	}

	@PutMapping

	public PhoneDetails update(@RequestBody PhoneDetails phoneDetails) {
		return phoneDetailsService.update(phoneDetails);
	}

	@DeleteMapping(value = "/{id}")

	public void delete(@PathVariable Long id) {
		phoneDetailsService.delete(id);
	}
}
