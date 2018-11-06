package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "Office")
@Data

public class Office implements Serializable {
	private static final long serialVersionUID = 4007374445519080685L;
	@Id
	@GeneratedValue
	private long id;

	private String name;
	@ManyToOne
	private Address address;
}
