package hiberExample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PhoneDetails {
	@Id
	@GeneratedValue
	private Long id;

	private String provider;

	private String technology;

}
