package hiberExample.dto;

import hiberExample.models.Company;
import lombok.Data;

@Data
public class OfficeBaseDto {
	private long id;
	private String name;
	private Company company;
}
