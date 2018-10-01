package hiberExample.models;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;

	@OneToOne
	private Adress adress;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
