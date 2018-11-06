package hiberExample.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name = "Employee")
@Data
public class Employee implements Serializable {
	private static final long serialVersionUID = -8862221534248259742L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Phone> phones;



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne(fetch = FetchType.LAZY)
	private EmployeeDetails employeeDetails;
}
