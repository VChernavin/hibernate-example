package hiberExample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private String provider = "N/A";

	@Enumerated(EnumType.STRING)
	private PhoneTechnology technology = PhoneTechnology.NA;


}
