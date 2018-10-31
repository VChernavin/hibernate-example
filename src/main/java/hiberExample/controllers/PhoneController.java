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

import hiberExample.models.Phone;
import hiberExample.services.PhoneService;

@RestController
@RequestMapping("/phone")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@GetMapping

	public @ResponseBody
	List<Phone> getAll() {
		return phoneService.getAll();
	}

	@GetMapping(value = "/{id}")

	public @ResponseBody
	Phone get(@PathVariable Long id) {
		return phoneService.get(id);
	}

	@GetMapping(value = "/provider")

	public @ResponseBody
	Phone getByProvider(@RequestParam String number) {
		return phoneService.getByNumber(number);
	}


	@PostMapping

	public void create(@RequestBody Phone phone) {
		phoneService.create(phone);
	}

	@PutMapping

	public Phone update(@RequestBody Phone phone) {
		return phoneService.update(phone);
	}

	@DeleteMapping(value = "/{id}")

	public void delete(@PathVariable Long id) {
		phoneService.delete(id);
	}
}
