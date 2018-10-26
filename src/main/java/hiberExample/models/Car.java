package hiberExample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "Car")
@Data
public class Car {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, name = "sdf")
	private String registrationNumber;
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false, foreignKey = @ForeignKey(name = "company_id"))
	private Company company;
}
