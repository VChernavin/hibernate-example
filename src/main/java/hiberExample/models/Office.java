package hiberExample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "Office")
@Data

public class Office {
	@Id
	@GeneratedValue
	private long id;

	private String name;
	@ManyToOne
	private Address address;
}
