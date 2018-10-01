package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hiberExample.models.Car;

@Repository
@Transactional
public class CarDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Car getById(long id) {
		return entityManager.find(Car.class, id);
	}

	public List<Car> getAll() {

		return entityManager.createQuery("from Car").getResultList();
	}

	public void create(Car car) {
		entityManager.persist(car);
	}
}
