package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity(name = "PhoneDetails")
@Data
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"provider", "technology"})})
public class PhoneDetails implements Serializable {
	private static final long serialVersionUID = 6852971138593126414L;
	@Id
	@GeneratedValue
	private Long id;

	private String provider = "N/A";

	@Enumerated(EnumType.STRING)
	private PhoneTechnology technology = PhoneTechnology.NA;

}
