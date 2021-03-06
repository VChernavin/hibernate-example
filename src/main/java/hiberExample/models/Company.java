package hiberExample.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "Company")
@Data
public class Company implements Serializable {

	private static final long serialVersionUID = 3321625058688177955L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String name;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "company_id")
	private List<Office>  offices;
}
