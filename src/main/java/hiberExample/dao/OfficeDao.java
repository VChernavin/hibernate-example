package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.helper.DozerHelper;
import hiberExample.models.Office;

@Repository
@Transactional
public class OfficeDao {

	@PersistenceContext
	private EntityManager entityManager;

	private final DozerHelper dozerHelper;

	@Autowired
	public OfficeDao(DozerHelper dozerHelper) {
		this.dozerHelper = dozerHelper;
	}

	public OfficeDto getById(long id) {
		return dozerHelper.map(entityManager.find(Office.class, id), OfficeDto.class);
	}

	public OfficeBaseDto getBaseById(long id) {
		return dozerHelper.map(entityManager.find(Office.class, id), OfficeBaseDto.class);
	}


	public List<Office> getAll() {

		return entityManager.createQuery("from Office").getResultList();
	}

	public void create(Office Office) {
		entityManager.persist(Office);
	}

	public Office update(Office Office) {
		return entityManager.merge(Office);
	}

	public void delete(long id) {
		Office Office = entityManager.find(Office.class, id);
		if (Office != null) {
			entityManager.remove(Office);
		}
	}
}
