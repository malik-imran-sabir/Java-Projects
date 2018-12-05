package org.api.security.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.security.model.UserEntity;
import org.api.security.model.UserVO;
import org.api.security.repository.UserRepository;
import org.api.security.security.TokenHelper;
import org.api.security.service.UserService;
import org.core.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private TokenHelper tokenHelper;
    
	private JsonUtil util = new JsonUtil();
    
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
    public UserVO findByUsername( String username ) throws UsernameNotFoundException {
    	/*//UserEntity u = userRepository.findByUsername( username );
		String sql = "SELECT u.id"
				+ ",u.name"
				+ ", u.fatherName"
				+ ",u.dob"
				+ ",u.doj"
				+ ",u.nic"
				+ ",u.userTypeId"
				+ ",u.madarsaId"
				+ ",u.image"
				+ ",u.createdOn"
				+ ",ud.permaddress AS address"
				+ ",u.location"
				+ ",ud.contact1"
				+ ",ud.contact2"
				+ ",ud.contact3 FROM `user` u "
				+ "LEFT JOIN userdetails ud ON u.id = ud.userId LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` WHERE u.username = :q1";
*/
		String sql = "SELECT "+
				"u.id"+
				",u.name"+
				",u.username"+
				",u.password"+
				",u.fatherName"+
				",u.dob"+
				",u.doj"+
				",u.createdOn"+
				",u.image"+
				",ud.fathernic"+
				",ud.permaddress AS address"+
				",ud.tempaddress"+
				",ud.permaddress"+
				",ud.locationId"+
				",ud.locationId AS location"+
				",ud.teacherId"+
				",ud.shiftId"+
				",ud.classId"+
				",ud.easyaccounttitle"+
				",ud.emobilenumber"+
				",ud.enic"+
				",ud.benefitamount"+
				",ud.salary"+
				",ud.madarsaId"+
				",ud.contact1"+
				",ud.contact2"+
				",ud.contact3"+
				",ud.qualification"+
				",ud.extraQualification"+
				",ud.modernQualification"+
				",ud.lastAttendedMadarsa"+
				",ud.lastQualificationDate"+
				",ud.otherMadarsas "+
				",u.userTypeId "+
				",u.nic "+
				",u.location l "+
			"FROM user u "+
			"LEFT JOIN userdetails ud ON u.id = ud.userId LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` WHERE u.username = :q1";
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", username);

		try {
			
			Object[] users = (Object[]) query.getSingleResult();
			UserVO user = new UserVO();
			
			user.setId((BigInteger) users[0]);
			user.setName((String)users[1]);
			user.setUsername((String)users[2]);
			user.setPassword((String)users[3]);
			user.setFatherName((String)users[4]);
			user.setDob((Date)users[5]);
			user.setDoj((Date)users[6]);
			user.setCreatedOn((Date)users[7]);
			user.setImage((String)users[8]);
			user.setFathernic((String)users[9]);
			user.setAddress((String)users[10]);
			user.setTempaddress((String)users[11]);
			user.setPermaddress((String)users[12]);
			user.setLocationId((String)users[13]);
			user.setLocation((String)users[14]);
			user.setTeacherId((String)users[15]);
			user.setShiftId((String)users[16]);
			user.setClassId((String)users[17]);
			user.setEasyaccounttitle((String)users[18]);
			user.setEmobilenumber((String)users[19]);
			user.setEnic((String)users[20]);
			user.setBenefitamount((String)users[21]);
			user.setSalary((String)users[22]);
			user.setMadarsaId((String)users[23]);
			user.setContact1((String)users[24]);
			user.setContact2((String)users[25]);
			user.setContact3((String)users[26]);
			user.setQualification((String)users[27]);
			user.setExtraQualification((String)users[28]);
			user.setModernQualification((String)users[29]);
			user.setLastAttendedMadarsa((String)users[30]);
			user.setLastQualificationDate((Date)users[31]);
			user.setOtherMadarsas((String)users[32]);
			user.setUserTypeId((String)users[33]);
			user.setCnic((String)users[34]);
			user.setLocation((String)users[35]);
			
		/*	UserVO user = new UserVO(
					(BigInteger) student[0], (String) student[1], (String) student[2],
					(Date) student[3], (Date) student[4], (String) student[5], (String) student[6], (BigInteger) student[7],
					(String) student[8], (Date) student[9], (String) student[10], (String) student[11], (String) student[12],(String)  student[13], (String) student[14]);
*/
			return user;
		//	return util.convertSingleEntityToJson(std);

		} catch (NoResultException e) {
			return null;
		}
		
    }

    public UserEntity findById( Long id ) throws AccessDeniedException {
    	UserEntity u = userRepository.findOne( id );
        return u;
    }

    public List<UserEntity> findAll() throws AccessDeniedException {
        List<UserEntity> result = userRepository.findAll();
        return result;
    }

	@Override
	public Claims validateToken(String token, UserEntity user) {
		return tokenHelper.getAllClaimsFromToken(token);
		
	}
}
