package hiberExample.dto;

import hiberExample.models.Company;
import lombok.Data;

@Data
public class CarDto {

	private long id;
	private String registrationNumber;
	private Company company;
}
