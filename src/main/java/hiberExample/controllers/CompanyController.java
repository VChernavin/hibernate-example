package hiberExample.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hiberExample.models.Company;
import hiberExample.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	List<Company> getAll() {
		return companyService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Company get(@PathVariable Long id) {
		return companyService.get(id);
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Company get(@RequestParam String name) {
		return companyService.get(name);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody Company company) {
		companyService.create(company);
		HttpHeaders headers = new HttpHeaders();
		//      /  ControllerLinkBuilder linkBuilder = linkTo(methodOn(CompanyController.class).get(company.getId()));

		//        headers.setLocation(linkBuilder.toUri());
		try {
			headers.setLocation(new URI(""));
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@RequestBody Company company) {
		companyService.update(company);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		companyService.delete(id);
	}

}