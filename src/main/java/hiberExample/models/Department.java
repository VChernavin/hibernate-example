package hiberExample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Department")
@Data
public class Department {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name;
}
