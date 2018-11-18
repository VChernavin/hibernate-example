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

import hiberExample.models.Address;
import hiberExample.services.AddressService;


@RestController
@RequestMapping("/address")
public class AddressController {
	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public @ResponseBody
	List<Address> getAll() {
		return addressService.getAll();
	}


	@PostMapping
	public void create(@RequestBody Address address) {
		addressService.create(address);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody
	Address get(@PathVariable Long id) {
		return addressService.get(id);
	}

	@PutMapping
	public void update(@RequestBody Address address) {
		addressService.update(address);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
	}
}
