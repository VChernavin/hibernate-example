package hiberExample.services;

import hiberExample.dao.DepartmentDao;
import hiberExample.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;


    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    @Cacheable(value = "department.byId", key = "#id", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
    public Department get(Long id) {
        return departmentDao.getById(id);
    }

    @Cacheable(value = "department.byName", key = "#name", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
    public Department get(String name) {
        return departmentDao.getByName(name);
    }

    public void create(Department company) {
        departmentDao.create(company);
    }

    public void update(Department company) {
        departmentDao.update(company);
    }

    public void delete(Long id) {
        departmentDao.delete(id);
    }
}
