package hiberExample.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "Department")
@Data
public class Department {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Company> companyes;
}
