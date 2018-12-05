package org.api.model.jpa.dao;

import java.io.Serializable;
import java.sql.Date;

import org.api.model.jpa.entity.UserDetailsEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAUserDetailsDAO extends BaseJPADAO<UserDetailsEntity, Serializable> {
	
	@Modifying
	@Query("UPDATE UserDetailsEntity u SET u.fathernic=:fathernic ,u.address=:address, u.tempaddress=:tempaddress, "
			+ "u.permaddress=:permaddress, u.locationId=:locationId, u.teacherId=:teacherId"
			+ ", u.shiftId=:shiftId, u.classId=:classId, u.easyaccounttitle=:easyaccounttitle, u.emobilenumber=:emobilenumber"
			+ ", u.enic=:enic, u.benefitamount=:benefitamount, u.salary=:salary, u.madarsaId=:madarsaId"
			+ ", u.contact1=:contact1, u.contact2=:contact2, u.contact3=:contact3, u.maritalStatus=:maritalStatus"
			+ ", u.qualification=:qualification, u.extraQualification=:extraQualification, u.modernQualification=:modernQualification  "
			+ ", u.lastAttendedMadarsa=:lastAttendedMadarsa "
			+ ", u.lastQualificationDate=:lastQualificationDate, u.otherMadarsas=:otherMadarsas "		
			+ ", u.guardianname=:guardianname, u.guardiannic=:guardiannic "
			+ ", u.guardianrelation=:guardianrelation "
			+ ", u.gardiannumber=:gardiannumber "
			+ " WHERE u.userId = :id")
	
	int updateDetailsUser(@Param("fathernic") String fathernic, @Param("address") String address, @Param("tempaddress") String tempaddress,
			@Param("permaddress") String permaddress, @Param("locationId") String locationId, @Param("teacherId") String teacherId,
			@Param("shiftId") String shiftId, @Param("classId") String classId, @Param("easyaccounttitle") String easyaccounttitle, @Param("emobilenumber") String emobilenumber,
			@Param("enic") String enic, @Param("benefitamount") String benefitamount, @Param("salary") String salary,@Param("madarsaId") String madarsaId,
			@Param("contact1") String contact1, @Param("contact2") String contact2, @Param("contact3") String contact3,@Param("maritalStatus") boolean  maritalStatus,
		@Param("qualification") String qualification, @Param("extraQualification") String extraQualification, @Param("modernQualification") String modernQualification,
		@Param("lastAttendedMadarsa") String lastAttendedMadarsa,
			@Param("lastQualificationDate") Date lastQualificationDate, 
			@Param("otherMadarsas") String otherMadarsas,
			
			@Param("guardianname") String guardianname,
			@Param("guardiannic") String guardiannic,
			@Param("guardianrelation") String guardianrelation,
			@Param("gardiannumber") String gardiannumber,
		@Param("id") long id);
		
	UserDetailsEntity findOneByUserId(long id);

}
