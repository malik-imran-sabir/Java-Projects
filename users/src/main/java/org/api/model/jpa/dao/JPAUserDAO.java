package org.api.model.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.api.model.jpa.entity.UserEntity;
import org.core.model.dao.BaseJPADAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAUserDAO extends BaseJPADAO<UserEntity, Serializable> {

	@Modifying
	@Query("UPDATE UserEntity u SET u.name=:name ,u.dob=:dob, u.doj=:doj, u.fatherName=:fatherName, u.image=:image, u.location=:location"
			+ ", u.madarsaId=:madarsaId, u.nic=:nic,  u.userTypeId=:userTypeId, u.passwordSalt=:passwordSalt, u.password=:password "
			+ " WHERE u.id = :userId")
	int updateUser(@Param("name") String name, @Param("dob") Date dob, @Param("doj") Date doj,
			@Param("fatherName") String fatherName, @Param("image") String image, @Param("location") String location,
			@Param("madarsaId") long madarsaId, @Param("nic") String nic,
			@Param("userTypeId") String userTypeId,
			@Param("passwordSalt") String passwordSalt,
			@Param("password") String password,
			@Param("userId") long userId);
	
	@Modifying
	@Query("UPDATE UserEntity u SET u.name=:name ,u.dob=:dob, u.doj=:doj, u.fatherName=:fatherName, u.image=:image, u.location=:location"
			+ ", u.madarsaId=:madarsaId, u.nic=:nic,  u.userTypeId=:userTypeId, u.password=:password WHERE u.id = :userId")
	int updateUserP(@Param("name") String name, @Param("dob") Date dob, @Param("doj") Date doj,
			@Param("fatherName") String fatherName, @Param("image") String image, @Param("location") String location,
			@Param("madarsaId") long madarsaId, @Param("nic") String nic,
			@Param("userTypeId") String userTypeId,@Param("password") String password, @Param("userId") long userId);
//	@Modifying
//	@Query("UPDATE UserEntity u SET u.name=:name ,u.dob=:dob, u.doj=:doj, u.fatherName=:fatherName, u.image=:image, u.location=:location"
//			+ ", u.madarsaId=:madarsaId, u.nic=:nic, u.password=:password, u.userTypeId=:userTypeId, u.username=:username "
//			+ "WHERE u.username = :username")
//	int updateUsername(@Param("name") String name, @Param("dob") Date dob, @Param("doj") Date doj,
//			@Param("fatherName") String fatherName, @Param("image") String image, @Param("location") String location,
//			@Param("madarsaId") long madarsaId, @Param("nic") String nic, @Param("password") String password,
//			@Param("userTypeId") String userTypeId, @Param("username") String username);
//	
	
/*
	@Modifying
	@Query("UPDATE UserEntity u SET ud.fathernic=: fathernic," + 
			"ud.address=: address," + 
			"ud.tempaddress=: tempaddress," + 
			"ud.permaddress=: permaddress," + 
			"ud.locationId=: locationId," + 
			"ud.teacherId=: teacherId, " + 
			"ud.shiftId=: shiftId," + 
			"ud.classId=: classId," + 
			"ud.easyaccounttitle=: easyaccounttitle," + 
			"ud.emobilenumber=: emobilenumber," + 
			"ud.enic=: enic," + 
			"ud.benefitamount=: benefitamount," + 
			"ud.salary=: salary," + 
			"ud.madarsaId=: madarsaId," + 
			"ud.contact1=: contact1," + 
			"ud.contact2=: contact2," + 
			"ud.contact3=: contact3," + 
			"ud.maritalStatus=: maritalStatus," + 
			"ud.qualification=: qualification," + 
			"ud.extraQualification=: extraQualification," + 
			"ud.modernQualification=: modernQualification," + 
			"ud.lastAttendedMadarsa=: lastAttendedMadarsa," + 
			"ud.lastQualificationDate=: lastQualificationDate," + 
			"ud.otherMadarsas=: otherMadarsas WHERE ud.userId=:userId")
	int updateUserDetails(@Param("name") String name, @Param("dob") Date dob, @Param("doj") Date doj,
			@Param("fatherName") String fatherName, @Param("image") String image, @Param("location") String location,
			@Param("madarsaId") String madarsaId, @Param("nic") String nic, @Param("password") String password,
			@Param("userTypeId") String userTypeId, @Param("username") String username,@Param("name") String name,
			@Param("dob") Date dob, @Param("doj") Date doj, @Param("fatherName") String fatherName, @Param("image") String image, 
			@Param("location") String location,@Param("madarsaId") String madarsaId, @Param("nic") String nic, @Param("password") String password,
			@Param("userTypeId") String userTypeId, @Param("username") String username, @Param("userId") long userId);*/
	
	Collection<UserEntity> findByUserTypeId(@Param("userTypeId") String userTypeId);

	Collection<UserEntity> findByMadarsaIdAndUserTypeIdIn(@Param("madarsaId") List<Long> madarsaId,
			@Param("userTypeId") String userTypeId);

}
