package hiberExample.services;

import java.util.List;

import hiberExample.models.Employee;

public interface EmployeeService {
	public List<Employee> getAll();

	public Employee get(Long id);

	public Employee get(String name);

	public Employee getBySurname(String surname);

	public void create(Employee employee);

	public void update(Employee employee);

	public void delete(Long id);
}
