package hiberExample.dto;

import lombok.Data;

@Data
public class AddressDto {
	private long id;
	private String houseNumber;
	private String street;
	private String zipCode;
}
