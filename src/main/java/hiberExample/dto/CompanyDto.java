package hiberExample.dto;

import java.util.List;

import hiberExample.models.Office;
import lombok.Data;

@Data
public class CompanyDto extends CompanyBaseDto {
	private List<Office> offices;
}
