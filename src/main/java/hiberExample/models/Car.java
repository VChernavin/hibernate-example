package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "Car")
@Data
public class Car implements Serializable {

	private static final long serialVersionUID = 2919956689810866665L;
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, unique = true)
	private String registrationNumber;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false, foreignKey = @ForeignKey(name = "company_id"))
	private Company company;
}
