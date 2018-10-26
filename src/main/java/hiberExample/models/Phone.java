package hiberExample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name = "Phone")
@Data
public class Phone {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "`number`")
	private String number;

	@OneToOne
	@JoinColumn(name = "details_id")
	private PhoneDetails details;

	public Phone(Long id) {
		this.id = id;
	}
}
