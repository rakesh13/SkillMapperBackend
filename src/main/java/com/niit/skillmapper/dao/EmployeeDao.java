package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Employee;

public interface EmployeeDao {

	boolean saveEmployee(Employee employee);
	boolean deleteEmployee(int empId);
	boolean updateEmployee(Employee employee);
	Employee getEmployeeById(int empId);
	List<Employee> getAllEmployees();
	boolean login(int empId,String password);
}
