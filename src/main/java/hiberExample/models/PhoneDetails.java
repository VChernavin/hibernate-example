package hiberExample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Entity(name = "PhoneDetails")
@Data
public class PhoneDetails {
	@Id
	@GeneratedValue
	private Long id;

	@ColumnDefault("'N/A'")
	private String provider;

	@ColumnDefault("'N/A'")
	private String technology;

}
