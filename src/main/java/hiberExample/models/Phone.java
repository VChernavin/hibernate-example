package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "Phone")
@Data
public class Phone implements Serializable {
	private static final long serialVersionUID = 4534997364572346033L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "`number`",unique = true)
	private String number;

	@ManyToOne
	@JoinColumn(name = "details_id")
	private PhoneDetails details;

}
