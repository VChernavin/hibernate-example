package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hiberExample.models.Office;

@Repository
@Transactional
public class OfficeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Office getById(long id) {
		return entityManager.find(Office.class, id);
	}

	public List<Office> getAll() {
		return entityManager.createQuery("from Office").getResultList();
	}

	public void create(Office office) {
		entityManager.persist(office);
	}

	@Transactional
	public void create(List<Office> offices) {
		for (Office office : offices) {
			entityManager.persist(office);
		}
	}

	public Office update(Office office) {
		return entityManager.merge(office);
	}

	public void delete(long id) {
		Office office = entityManager.find(Office.class, id);
		if (office != null) {
			entityManager.remove(office);
		}
	}
}
