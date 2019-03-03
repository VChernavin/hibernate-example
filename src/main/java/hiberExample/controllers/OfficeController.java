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

import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.models.Office;
import hiberExample.services.OfficeService;


@RestController
@RequestMapping("/api/office")
@CrossOrigin(origins = "http://localhost:3000")
public class OfficeController {

	private final OfficeService officeService;

	@Autowired
	public OfficeController(OfficeService officeService) {
		this.officeService = officeService;
	}

	@GetMapping
	public @ResponseBody
	List<Office> getAll() {
		return officeService.getAll();
	}


	@PostMapping
	public void create(@RequestBody Office office) {
		officeService.create(office);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody
	OfficeDto get(@PathVariable Long id) {
		return officeService.get(id);
	}


	@GetMapping(value = "/base/{id}")
	public @ResponseBody
	OfficeBaseDto getBase(@PathVariable Long id) {
		return officeService.getBase(id);
	}

	@PutMapping
	public void update(@RequestBody Office office) {
		officeService.update(office);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		officeService.delete(id);
	}
}
