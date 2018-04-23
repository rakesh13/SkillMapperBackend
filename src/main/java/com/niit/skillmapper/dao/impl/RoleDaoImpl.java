package com.niit.skillmapper.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.RoleDao;
import com.niit.skillmapper.model.Roles;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

	@Override
	public boolean addRole(Roles role) {
		// TODO Auto-generated method stub
		return false;
	}

}
