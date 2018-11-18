package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name = "Office")
@Data

public class Office implements Serializable {
	private static final long serialVersionUID = 4007374445519080685L;
	@Id
	@GeneratedValue
	private long id;

	private String name;
	@OneToOne(fetch = FetchType.LAZY)
	private Address address;

	private long company_id;
}
