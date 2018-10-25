package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hiberExample.models.Phone;

public class PhoneDao {

	@PersistenceContext
	private EntityManager entityManager;


	public Phone getById(long id) {
		return entityManager.find(Phone.class, id);
	}

	public Phone getByNumber(String number) {

		return (Phone) entityManager.createQuery("from Phone where number = :number ")
				.setParameter("number", number).getSingleResult();
	}

	public List<Phone> getAll() {

		return entityManager.createQuery("from Phone").getResultList();
	}

	public void create(Phone Phone) {
		entityManager.persist(Phone);
	}

	public void update(Phone Phone) {
		entityManager.merge(Phone);
	}

	public void delete(long id) {
		Phone Phone = entityManager.find(Phone.class, id);
		if (Phone != null) {
			entityManager.remove(Phone);
		}
	}
}
