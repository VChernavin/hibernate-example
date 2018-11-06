package hiberExample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hiberExample.dao.EmployeeDao;
import hiberExample.models.Employee;
import hiberExample.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Cacheable(value = "employee.byId", key = "#id", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Employee get(Long id) {
		return employeeDao.getById(id);
	}

	@Cacheable(value = "employee.byName", key = "#name", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Employee get(String name) {
		return employeeDao.getByName(name);
	}

	@Cacheable(value = "employee.bySurame", key = "#surname", unless = "#result != null and #result.name.toUpperCase().startsWith('TEST')")
	public Employee getBySurname(String surname) {
		return employeeDao.getBySurname(surname);
	}

	public void create(Employee employee) {
		employeeDao.create(employee);
	}

	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	public void delete(Long id) {
		employeeDao.delete(id);
	}
}
