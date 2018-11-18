package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hiberExample.dto.OfficeBaseDto;
import hiberExample.dto.OfficeDto;
import hiberExample.models.Office;

@Repository
@Transactional
public class OfficeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;


	public OfficeDto getById(long id) {
		return dozerBeanMapper.map(entityManager.find(Office.class, id), OfficeDto.class);
	}

	public OfficeBaseDto getBaseById(long id) {
		return dozerBeanMapper.map(entityManager.find(Office.class, id), OfficeBaseDto.class);
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
