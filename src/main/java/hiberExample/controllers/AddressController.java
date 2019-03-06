package hiberExample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hiberExample.dto.AddressDto;
import hiberExample.services.AddressService;


@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public @ResponseBody
	List<AddressDto> getAll() {
		return addressService.getAll();
	}


	@PostMapping
	public void create(@RequestBody AddressDto address) {
		addressService.create(address);
	}

	@PostMapping(value = "/list")
	public void create(@RequestBody List<AddressDto> addresses) {
		addressService.create(addresses);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody
	AddressDto get(@PathVariable Long id) {
		return addressService.get(id);
	}

	@PutMapping
	public void update(@RequestBody AddressDto address) {
		addressService.update(address);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
	}
}
