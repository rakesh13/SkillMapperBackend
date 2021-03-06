package com.niit.skillmapper.service;

import java.util.List;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skill;

public interface SkillsService {

	boolean addSkills(Skill skills);
	boolean deleteSkills(int skillId);
	boolean updateSkills(Skill skills);
	Skill getSkillsById(int skillId);
	List<Skill> getAllSkills();
	List<Employee> getAllEmployeesBySingleSkillName(String skillName);
	List<Skill> getAllSkillsByEmployeeId(int empId);
	List<Employee> getAllEmployeesByMultipleSkillName(String skillName);
}
