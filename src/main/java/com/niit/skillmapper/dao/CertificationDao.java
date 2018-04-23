package com.niit.skillmapper.dao;

import java.util.List;

import com.niit.skillmapper.model.Certification;

public interface CertificationDao {

	boolean addCertification(Certification certification);
	boolean deleteCertification(int certificateId);
	boolean updateCertification(Certification certification);
	Certification getCertificateById(int certificationId);
	List<Certification> getAllCertificates();
	List<Certification> getCertificatesByEmployeeId(int empId);
	//List<Employee> getCertificationByName(String certificateName);
}
