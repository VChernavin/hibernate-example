package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hiberExample.models.PhoneDetails;

@Repository
@Transactional
public class PhoneDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;

	public PhoneDetails getById(long id) {
		return entityManager.find(PhoneDetails.class, id);
	}

	public PhoneDetails getByProvider(String provider) {

		return (PhoneDetails) entityManager.createQuery("from PhoneDetails where provider = :provider ")
				.setParameter("provider", provider).getSingleResult();
	}

	public PhoneDetails getByTechnology(String technology) {

		return (PhoneDetails) entityManager.createQuery("from PhoneDetails where technology = :technology ")
				.setParameter("technology", technology).getSingleResult();
	}

	public List<PhoneDetails> getAll() {

		return entityManager.createQuery("from PhoneDetails").getResultList();
	}

	public void create(PhoneDetails PhoneDetails) {
		entityManager.persist(PhoneDetails);
	}

	public void update(PhoneDetails PhoneDetails) {
		entityManager.merge(PhoneDetails);
	}

	public void delete(long id) {
		PhoneDetails PhoneDetails = entityManager.find(PhoneDetails.class, id);
		if (PhoneDetails != null) {
			entityManager.remove(PhoneDetails);
		}
	}
}
