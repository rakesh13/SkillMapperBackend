package com.niit.skillmapper.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.CertificationDao;
import com.niit.skillmapper.model.Certification;

@Repository
@Transactional
public class CertificationDaoImpl implements CertificationDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean addCertification(Certification certification) {
		try {
			sessionFactory.getCurrentSession().save(certification);
			return true;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCertification(int certificateId) {
		try {
			sessionFactory.getCurrentSession().delete(getCertificateById(certificateId));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCertification(Certification certification) {
		try {
			sessionFactory.getCurrentSession().update(certification);
			return true;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Certification getCertificateById(int certificationId) {
		try
		{
			return sessionFactory.getCurrentSession().get(Certification.class, certificationId);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Certification> getAllCertificates() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("FROM Certification").list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Certification> getCertificatesByEmployeeId(int empId) {
		try
		{
			Query query = sessionFactory.getCurrentSession().createQuery("from Certification where empId=:empId");
			query.setInteger("empId", empId);
			List<Certification> list = query.list();
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
