package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity(name = "Address")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {
	private static final long serialVersionUID = 928649999054377027L;
	@Id
	@GeneratedValue
	private long id;
	private String houseNumber;
	private String street;
	private String zipCode;
}
