package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Employee;

public interface EmployeeDAO {

	Employee findByID(Integer id);

	List<Employee> findAll();
	
	List<Employee> findByDepartment(Department dep);

	void insert(Employee obj);

	void update(Employee obj);

	void deleteByID(Integer id);

}
