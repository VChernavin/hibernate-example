package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Department")
@Data
public class Department implements Serializable {
	private static final long serialVersionUID = -6883261395589284016L;
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name;
}
