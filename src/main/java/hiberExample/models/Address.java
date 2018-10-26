package hiberExample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Address")
@Data
public class Address {
	@Id
	@GeneratedValue
	private long id;
	private String houseNumber;
	private String street;
	private String zipCode;
}
