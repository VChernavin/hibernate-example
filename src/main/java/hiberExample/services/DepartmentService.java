package hiberExample.services;

import java.util.List;

import hiberExample.models.Department;

public interface DepartmentService {

	List<Department> getAll();

	Department get(Long id);

	Department get(String name);

	void create(Department company);

	void update(Department company);

	void delete(Long id);
}
