package hiberExample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hiberExample.models.Car;
import hiberExample.models.Company;

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

	public List<Car> getByCompany(String name) {
		return entityManager.createQuery("from Car as car where car.company.name like :name ")
				.setParameter("name", name).getResultList();
	}

	public void create(Car car) {
		entityManager.persist(car);
	}

	public void update(Car car) {
		entityManager.merge(car);
	}

	public void delete(long id) {
		Car car = entityManager.find(Car.class, id);
		if (car != null) {
			entityManager.remove(car);
		}
	}
}
