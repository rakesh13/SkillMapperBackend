package com.niit.skillmapper.dao.impl;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeDao;
import com.niit.skillmapper.dao.SkillsDao;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skill;

@Repository
@Transactional
public class SkillsDaoImpl implements SkillsDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public boolean addSkills(Skill skills) {
		try
		{
			sessionFactory.getCurrentSession().save(skills);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteSkills(int skillId) {
		try
		{
			sessionFactory.getCurrentSession().delete(getSkillsById(skillId));
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateSkills(Skill skills) {
		try
		{
			sessionFactory.getCurrentSession().update(skills);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Skill getSkillsById(int skillId) {
		return sessionFactory.getCurrentSession().get(Skill.class, skillId);
	}

	@Override
	public List<Skill> getAllSkills() {
		return sessionFactory.getCurrentSession().createQuery("From Skill").list();
	}

	@Override
	public List<Employee> getAllEmployeesBySingleSkillName(String skillName) {
		try{
			Query query = sessionFactory.getCurrentSession().createQuery("From Skill where skillName='"+skillName+"'");
			List<Skill> list = query.list();
			List<Employee> empList = new ArrayList<>();
			Employee emp = new Employee();
			for(Skill skill : list)
			{
				emp = employeeDao.getEmployeeById(skill.getEmployeeId());
				empList.add(emp);
			}
			return empList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Skill> getAllSkillsByEmployeeId(int empId) {
		try{
			Query query = sessionFactory.getCurrentSession().createQuery("From Skill where employeeId=?");
			query.setInteger(0, empId);
			List<Skill> skills = query.list();
			return skills;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	private List<String> getAllSkills(String skills)
	{
		List<String> allSkills=new ArrayList<>();
		String[] allStrings=skills.split(",");
		for(String s:allStrings)
		{
			String[] str=s.split(" ");
			if(str!=null)
			{
				for(String ss:str)
				if(!(ss.equals("and")||ss.equals("or")||ss.equals("the")))
				{
					allSkills.add(ss.trim());
				}
			}
		}
		
		//allSkills.forEach(System.out::println);
		return allSkills;
	}
	
	@Override
	public List<Employee> getAllEmployeesByMultipleSkillName(String skillName) {
		List<String> skillNames=getAllSkills(skillName);
		try{
			Query query = sessionFactory.getCurrentSession().createQuery("From Skill where skillName in (:skillnames)");
			query.setParameterList("skillnames", skillNames);
			List<Skill> list = query.list();
			List<Employee> empList = new ArrayList<>();
			Employee emp = new Employee();
			for(Skill skill : list)
			{
				emp = employeeDao.getEmployeeById(skill.getEmployeeId());
				if(!(empList.isEmpty()))
				{
					for(Employee e:empList)
					{
						if(e.getEmployeeId()!=emp.getEmployeeId())
						{
							empList.add(emp);
						}
					}
				}
				else
				{
					empList.add(emp);
				}
			}
			return empList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}

}
