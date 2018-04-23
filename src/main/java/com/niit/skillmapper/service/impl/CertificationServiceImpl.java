package com.niit.skillmapper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapper.dao.CertificationDao;
import com.niit.skillmapper.model.Certification;
import com.niit.skillmapper.service.CertificationService;

@Service
public class CertificationServiceImpl implements CertificationService{

	@Autowired
	private CertificationDao certificationDao;
	@Override
	public boolean addCertification(Certification certification) {
		return certificationDao.addCertification(certification);
	}

	@Override
	public boolean deleteCertification(int certificateId) {
		return certificationDao.deleteCertification(certificateId);
	}

	@Override
	public boolean updateCertification(Certification certification) {
		return certificationDao.updateCertification(certification);
	}

	@Override
	public Certification getCertificateById(int certificationId) {
		return certificationDao.getCertificateById(certificationId);
	}

	@Override
	public List<Certification> getAllCertificates() {
		return certificationDao.getAllCertificates();
	}

	@Override
	public List<Certification> getCertificatesByEmployeeId(int empId) {
		return certificationDao.getCertificatesByEmployeeId(empId);
	}

}
