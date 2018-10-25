package hiberExample.models;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Employee")
@Setter
@Getter
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Phone> phones;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Address> addresses;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
}
