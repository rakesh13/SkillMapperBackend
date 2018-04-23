package com.niit.skillmapper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapper.dao.EmployeeDao;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public boolean saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		//Employee emp=getEmployeeById(empId);
		return employeeDao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public boolean login(int empId, String password) {
		return employeeDao.login(empId, password);
	}

}
