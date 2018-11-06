package hiberExample.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "EmployeeDetails")
@Data
public class EmployeeDetails implements Serializable {
	private static final long serialVersionUID = 1090625571858785329L;

	@EmbeddedId
	private EmployeeDetailsPK pk;

	private Date birthday;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	private Float salary;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Address> addresses;

}
