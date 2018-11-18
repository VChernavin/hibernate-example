package hiberExample.dto;

import hiberExample.models.Address;
import lombok.Data;

@Data
public class OfficeDto extends OfficeBaseDto {

	private Address address;
}
