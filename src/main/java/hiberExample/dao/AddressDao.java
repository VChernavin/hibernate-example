package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hiberExample.models.Address;

@Repository
@Transactional
public class AddressDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Address getById(long id) {
		return entityManager.find(Address.class, id);
	}

	public List<Address> getByCompany(String name) {

		return entityManager.createQuery("from Address as address where address.company.name like :name ")
				.setParameter("name", name).getResultList();
	}

	public List<Address> getAll() {

		return entityManager.createQuery("from Address").getResultList();
	}

	public void create(Address Address) {
		entityManager.persist(Address);
	}

	@Transactional
	public void create(List<Address> addresses) {
		for (Address address : addresses) {
			entityManager.persist(address);
		}
	}

	public Address update(Address Address) {
		return entityManager.merge(Address);
	}

	public void delete(long id) {
		Address Address = entityManager.find(Address.class, id);
		if (Address != null) {
			entityManager.remove(Address);
		}
	}
}
