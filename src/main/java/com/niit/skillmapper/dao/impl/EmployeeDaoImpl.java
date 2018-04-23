package com.niit.skillmapper.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeDao;
import com.niit.skillmapper.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().save(employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int empId) {
		try {
			Employee employee = getEmployeeById(empId);
			sessionFactory.getCurrentSession().delete(employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().update(employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee getEmployeeById(int empId) {
		try {
			return sessionFactory.getCurrentSession().get(Employee.class, empId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return sessionFactory.getCurrentSession().createQuery("From Employee").list();
	}

	@Override
	public boolean login(int empId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
