package hiberExample.dao;

import hiberExample.models.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;


    public Department getById(long id) {
        return entityManager.find(Department.class, id);
    }

    public Department getByName(String name) {

        return (Department) entityManager.createQuery("from Department where name = :name ")
                .setParameter("name", name).getSingleResult();
    }

    public List<Department> getAll() {

        return entityManager.createQuery("from Department").getResultList();
    }

    public List<Department> getByCompany(String name) {
        return entityManager.createQuery("from Department as department where department.company.name like :name ")
                .setParameter("name", name).getResultList();
    }

    public void create(Department Department) {
        entityManager.persist(Department);
    }

    public void update(Department Department) {
        entityManager.merge(Department);
    }

    public void delete(long id) {
        Department Department = entityManager.find(Department.class, id);
        if (Department != null) {
            entityManager.remove(Department);
        }
    }
}
