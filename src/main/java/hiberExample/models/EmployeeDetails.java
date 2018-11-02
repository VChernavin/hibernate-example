package hiberExample.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "EmployeeDetails")
@Data
public class EmployeeDetails {
	@Id
	@GeneratedValue
	private long id;

	private Date birthday;
	private Gender gender;
	private Float salary;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Address> addresses;

}
