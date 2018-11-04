package hiberExample.services.impl;

import java.util.List;

import hiberExample.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hiberExample.dao.DepartmentDao;
import hiberExample.models.Department;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;


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
