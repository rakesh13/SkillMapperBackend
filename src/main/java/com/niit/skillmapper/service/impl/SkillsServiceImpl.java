package com.niit.skillmapper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapper.dao.SkillsDao;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skill;
import com.niit.skillmapper.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService{

	@Autowired
	private SkillsDao skillDao;
	@Override
	public boolean addSkills(Skill skills) {
		return skillDao.addSkills(skills);
	}

	@Override
	public boolean deleteSkills(int skillId) {
		return skillDao.deleteSkills(skillId);
	}

	@Override
	public boolean updateSkills(Skill skills) {
		return skillDao.updateSkills(skills);
	}

	@Override
	public Skill getSkillsById(int skillId) {
		return skillDao.getSkillsById(skillId);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDao.getAllSkills();
	}

	@Override
	public List<Employee> getAllEmployeesBySingleSkillName(String skillName) {
		return skillDao.getAllEmployeesBySingleSkillName(skillName);
	}

	@Override
	public List<Skill> getAllSkillsByEmployeeId(int empId) {
		return skillDao.getAllSkillsByEmployeeId(empId);
	}

	@Override
	public List<Employee> getAllEmployeesByMultipleSkillName(String skillName) {
		return skillDao.getAllEmployeesByMultipleSkillName(skillName);
	}

}
