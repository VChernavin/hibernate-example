package hiberExample.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class EmployeeDetailsPK implements Serializable {
	private static final long serialVersionUID = 8939643091327066613L;

	@Column(length = 2)
	private String passportSeries;
	@Column(length = 8)
	private int passportNumber;
}
