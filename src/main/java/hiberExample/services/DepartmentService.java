package hiberExample.services;

import hiberExample.models.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    Department get(Long id);

    Department get(String name);

    void create(Department company);

    void update(Department company);

    void delete(Long id);
}
