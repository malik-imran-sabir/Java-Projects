package org.api.services.impl;

import java.io.File;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.api.constants.Constants;
import org.api.model.jpa.dao.JPAContactDAO;
import org.api.model.jpa.dao.JPATeacherStudentDAO;
import org.api.model.jpa.dao.JPAUserAuthorityDAO;
import org.api.model.jpa.dao.JPAUserDAO;
import org.api.model.jpa.dao.JPAUserDetailsDAO;
import org.api.model.jpa.entity.ContactEntity;
import org.api.model.jpa.entity.TeacherStudentEntity;
import org.api.model.jpa.entity.UserAuthorityEntity;
import org.api.model.jpa.entity.UserDetailsEntity;
import org.api.model.jpa.entity.UserEntity;
import org.api.securitymodule.TrippleDes;
import org.api.vo.StudentVO;
import org.api.vo.UserDetailsVO;
import org.api.vo.UserVO;
import org.api.vo.AttendanceRegisterReportVO;
import org.api.vo.AttendanceReportVO;
import org.api.vo.AttendanceVO;
import org.api.vo.CommonUserVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDService;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.DateUtils;
import org.core.util.FileUploadUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The Class UserServiceImpl.
 */
@Service("UserService")
public class UserServiceImpl extends CRUDServiceImpl<UserEntity, UserVO> implements UserService {

	/** The Constant STATUS. */
	private static final String STATUS = "A";

	UserService service;
	/** The user DAO. */
	@Autowired
	private JPAUserDAO userDAO;

	/** The user contacts. */
	@Autowired
	private JPAContactDAO userContacts;

	/** The teacher student. */
	@Autowired
	private JPATeacherStudentDAO teacherStudent;

	@Autowired
	private JPAUserDetailsDAO userDetails;
	/** The user type. */
	@Autowired
	UserTypeService userType;

	/** The other user fields. */
	@Autowired
	private JPAUserAuthorityDAO userAuthority;
	
	
	/** The entity manager factory. */
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	  
	 
	 
	TrippleDes trippleDes;

	private String encryptpassword;
	  
	/**
	 * Instantiates a new user service impl.
	 *
	 * @param dao
	 *            the dao
	 */
	public UserServiceImpl(BaseDAO<UserEntity, Serializable> dao) {
		super(dao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.core.service.PopulateBeanPropertiesService#getDeepCopiedEntity(org.core.
	 * vo.BaseVO)
	 */
	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(UserVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, UserEntity.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.core.service.PopulateBeanPropertiesService#getDeepCopiedVO(org.core.model
	 * .entity.BaseEntity)
	 */
	@Override
	public <ENTITY extends BaseEntity> UserVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, UserVO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.api.services.impl.UserService#usersByType(long)
	 */
	@Override
	public ResponseEntity<JSONResponse<?>> usersByType(long userTypeId) {
		
/*		String sql = " select * from user where usertypeid  = :q1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", userTypeId);

		try {
						
			List<Object[]> attendanceRecords =  query.getResultList();
			List<AttendanceReportVO> attendanceList = new ArrayList<>();

			attendanceRecords.forEach(datalist -> {
				
				AttendanceReportVO attendance = new AttendanceReportVO();
				
				
				attendance.setId((BigInteger)datalist[0]);
				attendance.setDate((java.sql.Date)datalist[1]);
				attendance.setEndTime((Timestamp)datalist[2]);
				attendance.setStartTime((Timestamp)datalist[3]);
				
				attendance.setLessonEnd((String)datalist[4]);
				attendance.setLessonStart((String)datalist[5]);
				
				
				attendance.setPresenceStatus((String)datalist[6]);
				attendance.setFathername((String)datalist[7]);
				attendance.setName((String)datalist[8]);
				attendance.setMadrasaname((String)datalist[9]);
				attendance.setClassname((String)datalist[10]);
				
				attendanceList.add(attendance);		
			});

			return JsonUtil.convertIntoJson(attendanceList);

		} catch (NoResultException e) {
			return null;
		}*/
	Collection<UserEntity> records = userDAO.findByUserTypeId(String.valueOf(userTypeId));

		records.forEach(user -> {

			try {

				user.setUserTypeId(userType.getById(String.valueOf(user.getUserTypeId())).getName());

			} catch (Throwable e) {
				e.printStackTrace();
			}

		});

		return JsonUtil.convertIntoJson(records);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> userexist(String username) {

		String sql = " select id,username from user u WHERE u.username = :q1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", username);

		try {
			
			Object[] users = (Object[]) query.getSingleResult();
			StudentVO user = new StudentVO();
			user.setUsername((String)users[1]);
			return JsonUtil.convertSingleEntityToJson(user);

		} catch (NoResultException e) {
			return null;
		}
	}


	/**
	 * Save user fields.
	 *
	 * @param user
	 *            the user
	 * @param insertedUser
	 *            the inserted user
	 * @param currentTime
	 *            the current time
	 * @throws Exception
	 */
	private UserDetailsEntity saveUserDetails(CommonUserVO user, UserEntity insertedUser, Date currentTime) {
		try {
			UserDetailsEntity userDetailsEntity = BeanUtils.shallowCopy(user, UserDetailsEntity.class);
			userDetailsEntity.setUserId(insertedUser.getId());
			userDetailsEntity.setCreatedOn(currentTime);
			userDetailsEntity.setLastUpdatedOn(currentTime);
			return userDetails.save(userDetailsEntity);

		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Save contact.
	 *
	 * @param user
	 *            the user
	 * @param insertedUser
	 *            the inserted user
	 * @param currentTime
	 *            the current time
	 */
	private void saveContact(CommonUserVO user, UserEntity insertedUser, Date currentTime) {
		ContactEntity contactEntity = null;

		if (user.getContact1() != null) {
			contactEntity = new ContactEntity();
			contactEntity.setContact(user.getContact1());
			contactEntity.setContactTypeId(Constants.contactType1);
			contactEntity.setUserId(insertedUser.getId());
			contactEntity.setCreatedOn(currentTime);
			contactEntity.setLastUpdatedOn(currentTime);
			userContacts.save(contactEntity);

		}
		if (user.getContact2() != null) {
			contactEntity = new ContactEntity();
			contactEntity.setContact(user.getContact2());
			contactEntity.setContactTypeId(Constants.contactType2);
			contactEntity.setUserId(insertedUser.getId());
			contactEntity.setCreatedOn(currentTime);
			contactEntity.setLastUpdatedOn(currentTime);
			userContacts.save(contactEntity);

		}
		if (user.getContact3() != null) {
			contactEntity = new ContactEntity();
			contactEntity.setContact(user.getContact3());
			contactEntity.setContactTypeId(Constants.contactType3);
			contactEntity.setUserId(insertedUser.getId());
			contactEntity.setCreatedOn(currentTime);
			contactEntity.setLastUpdatedOn(currentTime);
			userContacts.save(contactEntity);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.api.services.impl.UserService#userDetail()
	 */
	@Override
	public ResponseEntity<JSONResponse<?>> userDetail() {
		Collection<UserEntity> users = userDAO.findAll();
		users.forEach(item -> {
			try {
				item.setUserTypeId(userType.getById(String.valueOf(item.getUserTypeId())).getName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
		});
		return JsonUtil.convertIntoJson(users);
	}
	@Override
	public ResponseEntity<JSONResponse<?>> allUserList() {
		Collection<UserEntity> users = userDAO.findAll();
		users.forEach(item -> {
			try {
				item.setUserTypeId(userType.getById(String.valueOf(item.getUserTypeId())).getName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
		});
		return JsonUtil.convertIntoJson(users);
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.api.services.impl.UserService#saveStudent(org.api.vo.UserVO,
	 * java.lang.String)
	 */
	@Override
	public ResponseEntity<JSONResponse<?>> saveUpdateUser(CommonUserVO student, String imageath) {
		Date currentTime = DateUtils.getCurrentDateTime();
		
		long madarsaId = student.getMadarsaId() != null ? Long.parseLong(student.getMadarsaId()) : 0;
		try {
				UserEntity userEntity  = BeanUtils.shallowCopy(student, UserEntity.class);;
				
				if(student.getId()==null || student.getId()==0) {
				
					// uploading a image file.
					
					try {
						
						if (student.getImage() != null) {
							byte[] byteImage = FileUploadUtils.decode(student.getImage());
							String path = FileUploadUtils.UploadFile(byteImage, imageath);
							path = path.split("web")[2];
							userEntity.setImage(path);
						}
						
					} catch (Exception e) {
						
					}
					

					try {
						if (student.getImageString() != null) {
							byte[] byteImage = FileUploadUtils.decode(student.getImageString());
							String path = FileUploadUtils.UploadFile(byteImage, imageath);
							path = path.split("web")[2];
							userEntity.setImage(path);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					TrippleDes td= new TrippleDes();
					
					//String encopass = student.getPassword() !=null && !"".equals(student.getPassword()) ? td.encrypt(student.getPassword()):"";
					
					String password  = student.getPasswordSalt() !=null && !"".equals(student.getPasswordSalt()) ? passwordEncoder.encode(student.getPasswordSalt()) : "";
					
					String encopass = student.getPasswordSalt() !=null && !"".equals(student.getPasswordSalt()) ? td.encrypt(student.getPasswordSalt()):"";

					userEntity.setPasswordSalt(encopass);
					
					//String decodeCheck = student.getPassword() !=null && !"".equals(student.getPassword()) ? trippleDes.decrypt(password):"";
					
					userEntity.setPassword(password);
					
					/***save user entity**/
					//String password  = student.getPassword() !=null && !"".equals(student.getPassword()) ? passwordEncoder.encode(student.getPassword()) : "";
					
					//String encopass = student.getPassword() !=null && !"".equals(student.getPassword()) ? trippleDes.encrypt(student.getPassword()):"";
				
					//String decodeCheck = student.getPassword() !=null && !"".equals(student.getPassword()) ? trippleDes.decrypt(password):"";
					
					//userEntity.setPassword(password);
					userEntity.setMadarsaId(madarsaId);
					userEntity.setCreatedOn(currentTime);
					userEntity.setLastUpdatedOn(currentTime);
					UserEntity insertedUser = userDAO.save(userEntity);
		
					/***save other information related to user**/
					if (insertedUser != null) {
						saveTeacherStudentRelation(insertedUser, student, currentTime);
						saveUserDetails(student, insertedUser, currentTime);
						saveUserAuthority(insertedUser, currentTime);
		
					}
					
					/***get user information with detail**/
					return getUser(userEntity.getId());
				
				} else if(student.getId()!=null && student.getId()!=0) {
					
					UserDetailsEntity userDetail= userDetails.findOneByUserId(student.getId());
					
					UserEntity enity  = BeanUtils.shallowCopy(student, UserEntity.class);
					// uploading a image file.`
					
					try {
						if (student.getImage() != null) {
							byte[] byteImage = FileUploadUtils.decode(student.getImage());
							String path = FileUploadUtils.UploadFile(byteImage, imageath);
							path = path.split("web")[2];
							enity.setImage(path);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						if (student.getImageString() != null) {
							byte[] byteImage = FileUploadUtils.decode(student.getImageString());
							String path = FileUploadUtils.UploadFile(byteImage, imageath);
							path = path.split("web")[2];
							enity.setImage(path);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
					
					enity.setCreatedOn(currentTime);
					enity.setLastUpdatedOn(currentTime);
					enity.setUsername(student.getUsername());
					enity.setId(student.getId());
					
					UserDetailsEntity userDetailsEntity  = BeanUtils.shallowCopy(student, UserDetailsEntity.class);
					userDetailsEntity.setCreatedOn(currentTime);
					userDetailsEntity.setLastUpdatedOn(currentTime);
					if(userDetail!=null) userDetailsEntity.setId(userDetail.getId());
					userDetailsEntity.setUserId(student.getId());
					userDetailsEntity.setUser(enity);
					
					userDetailsEntity.setEnic(student.getEnic());
					
					userDetailsEntity.setQualification(student.getQualification());
					userDetailsEntity.setExtraQualification(student.getExtraQualification());
					userDetailsEntity.setLastQualificationDate(student.getLastQualificationDate());
					
					userDetailsEntity.setGuardianname(student.getGuardianname());
					userDetailsEntity.setGuardiannic(student.getGuardiannic());
					userDetailsEntity.setGuardianrelation(student.getGuardianrelation());
					
					userDetailsEntity.setGardiannumber(student.getGardiannumber());
					
					String encryptedPassword  = encrypt("12345678");
					
					//String decryptPassword = decrypt(encryptedPassword);
					
					if(student.isMaritalStatus()==1)
						userDetailsEntity.setMaritalStatus(true);
					else
						userDetailsEntity.setMaritalStatus(false);
					
					enity.setUserDetails(userDetailsEntity);
					
					//String password  = student.getPassword() !=null && !"".equals(student.getPassword()) ? passwordEncoder.encode(student.getPassword()) : "";
					
					
					TrippleDes td= new TrippleDes();
					
					//String encopass = student.getPassword() !=null && !"".equals(student.getPassword()) ? td.encrypt(student.getPassword()):"";
					
					String password  = student.getPasswordSalt() !=null && !"".equals(student.getPasswordSalt()) ? passwordEncoder.encode(student.getPasswordSalt()) : "";
					
					String encopass = student.getPasswordSalt() !=null && !"".equals(student.getPasswordSalt()) ? td.encrypt(student.getPasswordSalt()):"";

					enity.setPasswordSalt(encopass);
					
					//String decodeCheck = student.getPassword() !=null && !"".equals(student.getPassword()) ? trippleDes.decrypt(password):"";
					
					enity.setPassword(password);
					
					userDAO.updateUser(enity.getName(), enity.getDob(), enity.getDoj(), enity.getFatherName(), 
							enity.getImage(), enity.getLocation(), madarsaId, enity.getNic(), 
							 enity.getUserTypeId(), 
							 enity.getPasswordSalt(),
							 enity.getPassword(),
							 student.getId());
					
					/*	userDAO.updateUserP(enity.getName(), enity.getDob(), enity.getDoj(), enity.getFatherName(), 
							enity.getImage(), enity.getLocation(), madarsaId, enity.getNic(), 
							 enity.getUserTypeId(), 
							 enity.getPassword(),
							 student.getId());*/

					
					userDetails.updateDetailsUser(
							userDetailsEntity.getFathernic(), userDetailsEntity.getAddress(),
							userDetailsEntity.getTempaddress(), userDetailsEntity.getPermaddress(), userDetailsEntity.getLocationId(),
							userDetailsEntity.getTeacherId(), userDetailsEntity.getShiftId(), userDetailsEntity.getClassId(), 
							userDetailsEntity.getEasyaccounttitle(),userDetailsEntity.getEmobilenumber(), 
							userDetailsEntity.getEnic(), userDetailsEntity.getBenefitamount(),userDetailsEntity.getSalary(), 
							userDetailsEntity.getMadarsaId(), student.getContact1(), userDetailsEntity.getContact2(), 
							userDetailsEntity.getContact3(), userDetailsEntity.isMaritalStatus(),userDetailsEntity.getQualification()
							,userDetailsEntity.getExtraQualification(),userDetailsEntity.getModernQualification() 
							,userDetailsEntity.getLastAttendedMadarsa(), userDetailsEntity.getLastQualificationDate(), 
							userDetailsEntity.getOtherMadarsas(),
							userDetailsEntity.getGuardianname(),
							userDetailsEntity.getGuardiannic(),
							userDetailsEntity.getGuardianrelation(),
							userDetailsEntity.getGardiannumber(),
							student.getId());
	    
					return getUser(student.getId());
				}
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * Save teacher student relation.
	 *
	 * @param insertedUser
	 *            the inserted user
	 * @param user
	 *            the user
	 * @param currentTime
	 *            the current time
	 * @return the teacher student entity
	 */
	private TeacherStudentEntity saveTeacherStudentRelation(UserEntity insertedUser, CommonUserVO user, Date currentTime) {
		long teacherId = user.getTeacherId() != null ? Long.valueOf(user.getTeacherId()) : 0;
		TeacherStudentEntity teacherStudentEntity = new TeacherStudentEntity();
		teacherStudentEntity.setStudentId(insertedUser.getId());
		teacherStudentEntity.setTeacherId(teacherId);
		teacherStudentEntity.setCreatedOn(currentTime);
		teacherStudentEntity.setLastUpdatedOn(currentTime);
		teacherStudentEntity.setStatus("A");
		return teacherStudent.save(teacherStudentEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.api.services.impl.UserService#Liststudents(long)
	 */
	@Override
	public ResponseEntity<JSONResponse<?>> Liststudents(long teacherId) {

		// JsonUtil util = new JsonUtil();

		/*String sql = "SELECT DISTINCT (u.id) id,u.name, u.fatherName,u.dob,u.doj, u.createdOn,u.image, ud.fathernic, ud.permaddress AS address, ud.locationId AS location, ud.teacherId, ud.shiftId, ud.classId, " + 
					" ud.contact1,ud.contact2,ud.contact3 " + 
					" FROM `user` u LEFT JOIN userdetails ud ON u.id = ud.userId LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` WHERE  ts.`teacherId` = :q1";
*/
		String sql = "SELECT "+
				"u.id"+
				",u.name"+
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
				",ud.guardianname "+
				",ud.guardiannic "+
				",ud.guardianrelation "+
				",ud.gardiannumber "+
			"FROM `user` u LEFT JOIN userdetails ud ON u.id = ud.userId "
			+ "LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` WHERE u.userTypeId = 4 and  ts.`teacherId` = :q1";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", teacherId);

		List<Object[]> studentRecords = query.getResultList();
		List<StudentVO> studentsList = new ArrayList<>();

		studentRecords.forEach(student -> {
			
			StudentVO user = new StudentVO();
			
			user.setId((BigInteger) student[0]);
			user.setName((String)student[1]);
			user.setFatherName((String)student[2]);
			user.setDob((Date)student[3]);
			user.setDoj((Date)student[4]);
			user.setCreatedOn((Date)student[5]);
			user.setImage((String)student[6]);
			user.setFathernic((String)student[7]);
			user.setAddress((String)student[8]);
			user.setTempaddress((String)student[9]);
			user.setPermaddress((String)student[10]);
			user.setLocationId((String)student[11]);
			user.setLocation((String)student[12]);
			user.setTeacherId((String)student[13]);
			user.setShiftId((String)student[14]);
			user.setClassId((String)student[15]);
			user.setEasyaccounttitle((String)student[16]);
			user.setEmobilenumber((String)student[17]);
			user.setEnic((String)student[18]);
			user.setBenefitamount((String)student[19]);
			user.setSalary((String)student[20]);
			user.setMadarsaId((String)student[21]);
			user.setContact1((String)student[22]);
			user.setContact2((String)student[23]);
			user.setContact3((String)student[24]);
			user.setQualification((String)student[25]);
			user.setExtraQualification((String)student[26]);
			user.setModernQualification((String)student[27]);
			user.setLastAttendedMadarsa((String)student[28]);
			user.setLastQualificationDate((Date)student[29]);
			user.setOtherMadarsas((String)student[30]);
			user.setGuardianname((String)student[31]);
			user.setGuardiannic((String)student[32]);
			user.setGuardianrelation((String)student[33]);
			user.setGardiannumber((String)student[34]);
			studentsList.add(user);
			
			/*StudentVO user = new StudentVO();
			
			user.setId((BigInteger) student[0]);
			user.setName((String)student[1]);
			user.setFatherName((String)student[2]);
			user.setDob((Date)student[3]);
			user.setDoj((Date)student[4]);
			user.setCreatedOn((Date)student[5]);
			user.setImage((String)student[6]);
			user.setFathernic((String)student[7]);
			user.setPermaddress((String)student[8]);
			user.setAddress((String)student[8]);
			user.setLocationId((String)student[9]);
			user.setLocation((String)student[9]);
			user.setTeacherId((String)student[10]);
			user.setShiftId((String)student[11]);
			user.setClassId((String)student[12]);
			user.setContact1((String)student[13]);
			user.setContact2((String)student[14]);
			user.setContact3((String)student[15]);*/
			
			
		});

		return JsonUtil.convertIntoJson(studentsList);
	}
	
	@Override
	public ResponseEntity<JSONResponse<?>> getstudentlist() {

		String sql = "SELECT "+
				"u.id"+
				",u.name"+
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
				",ud.guardianname "+
				",ud.guardiannic "+
				",ud.guardianrelation "+
				",u.userTypeId "+
				",ud.gardiannumber "+
			"FROM `user` u LEFT JOIN userdetails ud ON u.id = ud.userId LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` WHERE  u.userTypeId = 4  ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> studentRecords = query.getResultList();
		List<StudentVO> studentsList = new ArrayList<>();

		studentRecords.forEach(student -> {
			
			StudentVO user = new StudentVO();
			
			user.setId((BigInteger) student[0]);
			user.setName((String)student[1]);
			user.setFatherName((String)student[2]);
			user.setDob((Date)student[3]);
			user.setDoj((Date)student[4]);
			user.setCreatedOn((Date)student[5]);
			user.setImage((String)student[6]);
			user.setFathernic((String)student[7]);
			user.setAddress((String)student[8]);
			user.setTempaddress((String)student[9]);
			user.setPermaddress((String)student[10]);
			user.setLocationId((String)student[11]);
			user.setLocation((String)student[12]);
			user.setTeacherId((String)student[13]);
			user.setShiftId((String)student[14]);
			user.setClassId((String)student[15]);
			user.setEasyaccounttitle((String)student[16]);
			user.setEmobilenumber((String)student[17]);
			user.setEnic((String)student[18]);
			user.setBenefitamount((String)student[19]);
			user.setSalary((String)student[20]);
			user.setMadarsaId((String)student[21]);
			user.setContact1((String)student[22]);
			user.setContact2((String)student[23]);
			user.setContact3((String)student[24]);
			user.setQualification((String)student[25]);
			user.setExtraQualification((String)student[26]);
			user.setModernQualification((String)student[27]);
			user.setLastAttendedMadarsa((String)student[28]);
			user.setLastQualificationDate((Date)student[29]);
			user.setOtherMadarsas((String)student[30]);
			user.setGuardianname((String)student[31]);
			user.setGuardiannic((String)student[32]);
			user.setGuardianrelation((String)student[33]);
			user.setUserTypeId((String)student[34]);
			user.setGardiannumber((String)student[35]);
			studentsList.add(user);
			
			/*StudentVO user = new StudentVO();
			
			user.setId((BigInteger) student[0]);
			user.setName((String)student[1]);
			user.setFatherName((String)student[2]);
			user.setDob((Date)student[3]);
			user.setDoj((Date)student[4]);
			user.setCreatedOn((Date)student[5]);
			user.setImage((String)student[6]);
			user.setFathernic((String)student[7]);
			user.setPermaddress((String)student[8]);
			user.setAddress((String)student[8]);
			user.setLocationId((String)student[9]);
			user.setLocation((String)student[9]);
			user.setTeacherId((String)student[10]);
			user.setShiftId((String)student[11]);
			user.setClassId((String)student[12]);
			user.setContact1((String)student[13]);
			user.setContact2((String)student[14]);
			user.setContact3((String)student[15]);*/
			
			
		});

		return JsonUtil.convertIntoJson(studentsList);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> salaryReportList() {

		String sql = "SELECT "+
				"u.id"+
				",u.name as Name"+
				",u.fatherName "+
				",u.dob"+
				",u.doj"+
				",u.image"+
				",ud.fathernic"+
				",ud.permaddress AS address"+
				",ud.tempaddress"+
				",ud.permaddress"+
				",ud.enic"+
				",ud.benefitamount"+
				",ud.salary"+
				",ud.contact1"+
				",ud.contact2"+
				",ud.contact3"+
				",u.userTypeId "+
			" FROM `user` u LEFT JOIN userdetails ud ON u.id = ud.userId "
			+ " LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` where u.userTypeId in (1,2) ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> studentRecords = query.getResultList();
		List<StudentVO> studentsList = new ArrayList<>();

		studentRecords.forEach(student -> {
			
			StudentVO user = new StudentVO();
			
			user.setId((BigInteger) student[0]);
			user.setName((String)student[1]);
			user.setFatherName((String)student[2]);
			user.setDob((Date)student[3]);
			user.setDoj((Date)student[4]);
			user.setImage((String)student[5]);
			user.setFathernic((String)student[6]);
			user.setAddress((String)student[7]);
			user.setTempaddress((String)student[8]);
			user.setPermaddress((String)student[9]);
			user.setEnic((String)student[10]);
			user.setBenefitamount((String)student[11]);
			user.setSalary((String)student[12]);
			user.setContact1((String)student[13]);
			user.setContact2((String)student[14]);
			user.setContact3((String)student[15]);
			user.setUserTypeId((String)student[16]);
			studentsList.add(user);		
		});

		return JsonUtil.convertIntoJson(studentsList);
	}

	
	@Override
	public ResponseEntity<JSONResponse<?>> monthlyAttendanceReport() {

		String sql = " select a.`id`,a.`date`,a.`endTime`,a.startTime,a.lessonStart,a.lessonEnd,a.presenceStatus,u.fatherName,u.name,"
				+ " ob.name as madrasaname, c.name classname from cifstech_user.attendance a"
				+ " left join cifstech_user.user u on u.id = a.userId "
				+" left join cifstech_user.userdetails ud on ud.userId = u.id "
				+" left join cifstech_org.organizationbranch ob on ob.id = ud.madarsaId "
				+" left join cifstech_user.class c on c.id = a.classId ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<AttendanceReportVO> attendanceList = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			AttendanceReportVO attendance = new AttendanceReportVO();
			
			
			attendance.setId((BigInteger)datalist[0]);
			attendance.setDate((java.sql.Date)datalist[1]);
			attendance.setEndTime((Timestamp)datalist[2]);
			attendance.setStartTime((Timestamp)datalist[3]);
			
			attendance.setLessonEnd((String)datalist[4]);
			attendance.setLessonStart((String)datalist[5]);
			
			
			attendance.setPresenceStatus((String)datalist[6]);
			attendance.setFathername((String)datalist[7]);
			attendance.setName((String)datalist[8]);
			attendance.setMadrasaname((String)datalist[9]);
			attendance.setClassname((String)datalist[10]);
			
			attendanceList.add(attendance);		
		});

		return JsonUtil.convertIntoJson(attendanceList);
	}
	
	
	@Override
	public ResponseEntity<JSONResponse<?>> salaryRegisterReport() {

		String sql = " SELECT a.`userId`,Day(a.date) Day,a.date,u.name,u.fatherName, "
  +" GROUP_CONCAT(if(DAY(`date`) = 1, `presenceStatus`, NULL)) AS 'day1'," 
  +"GROUP_CONCAT(if(DAY(`date`) = 2, `presenceStatus`, NULL)) AS 'day2', "
  +"GROUP_CONCAT(if(DAY(`date`) = 3, `presenceStatus`, NULL)) AS 'day3'," 
  +"GROUP_CONCAT(if(DAY(`date`) = 4, `presenceStatus`, NULL)) AS 'day4', "
  +"GROUP_CONCAT(if(DAY(`date`) = 5, `presenceStatus`, NULL)) AS 'day5', "
  +"GROUP_CONCAT(if(DAY(`date`) = 6, `presenceStatus`, NULL)) AS 'day6', "
  +"GROUP_CONCAT(if(DAY(`date`) = 7, `presenceStatus`, NULL)) AS 'day7', "
  +"GROUP_CONCAT(if(DAY(`date`) = 8, `presenceStatus`, NULL)) AS 'day8', "
  +"GROUP_CONCAT(if(DAY(`date`) = 9, `presenceStatus`, NULL)) AS 'day9', "
  +"GROUP_CONCAT(if(DAY(`date`) = 10, `presenceStatus`, NULL)) AS 'day10',"
  +"GROUP_CONCAT(if(DAY(`date`) = 11, `presenceStatus`, NULL)) AS 'day11', "
  +"GROUP_CONCAT(if(DAY(`date`) = 12, `presenceStatus`, NULL)) AS 'day12', "
  +"GROUP_CONCAT(if(DAY(`date`) = 13, `presenceStatus`, NULL)) AS 'day13', "
  +"GROUP_CONCAT(if(DAY(`date`) = 14, `presenceStatus`, NULL)) AS 'day14', "
  +"GROUP_CONCAT(if(DAY(`date`) = 15, `presenceStatus`, NULL)) AS 'day15', "
  +"GROUP_CONCAT(if(DAY(`date`) = 16, `presenceStatus`, NULL)) AS 'day16', "
  +"GROUP_CONCAT(if(DAY(`date`) = 17, `presenceStatus`, NULL)) AS 'day17', "
  +"GROUP_CONCAT(if(DAY(`date`) = 18, `presenceStatus`, NULL)) AS 'day18', "
  +"GROUP_CONCAT(if(DAY(`date`) = 19, `presenceStatus`, NULL)) AS 'day19', "
  +"GROUP_CONCAT(if(DAY(`date`) = 20, `presenceStatus`, NULL)) AS 'day20', "
  +"GROUP_CONCAT(if(DAY(`date`) = 21, `presenceStatus`, NULL)) AS 'day21', "
  +"GROUP_CONCAT(if(DAY(`date`) = 22, `presenceStatus`, NULL)) AS 'day22', "
  +"GROUP_CONCAT(if(DAY(`date`) = 23, `presenceStatus`, NULL)) AS 'day23', "
  +"GROUP_CONCAT(if(DAY(`date`) = 24, `presenceStatus`, NULL)) AS 'day24', "
  +"GROUP_CONCAT(if(DAY(`date`) = 25, `presenceStatus`, NULL)) AS 'day25', "
  +"GROUP_CONCAT(if(DAY(`date`) = 26, `presenceStatus`, NULL)) AS 'day26', "
  +"GROUP_CONCAT(if(DAY(`date`) = 27, `presenceStatus`, NULL)) AS 'day27', "
  +"GROUP_CONCAT(if(DAY(`date`) = 28, `presenceStatus`, NULL)) AS 'day28', "
  +"GROUP_CONCAT(if(DAY(`date`) = 29, `presenceStatus`, NULL)) AS 'day29', "
  +"GROUP_CONCAT(if(DAY(`date`) = 30, `presenceStatus`, NULL)) AS 'day30',  "
  +"GROUP_CONCAT(if(DAY(`date`) = 31, `presenceStatus`, NULL)) AS 'day31', "
  +"COUNT(if(a.`presenceStatus`='P', `presenceStatus`, NULL)) AS 'totalP'," 
  + " a.`lessonStart`, a.`lessonEnd` "
+" FROM `attendance` as a "
+" left join `user` as u on u.`id` = a.`userId` "
+" GROUP BY a.`userId`, Day(a.date), Year(a.date) ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		//query.setParameter("q1", teacherId);

		List<Object[]> attendanceRecords =  query.getResultList();
		List<AttendanceRegisterReportVO> attendanceList = new ArrayList<>();

		attendanceRecords.forEach(datalist -> {
			
			AttendanceRegisterReportVO attendance = new AttendanceRegisterReportVO();
			
			
			//attendance.setId((BigInteger)datalist[0]);
			//1 is only day 
			attendance.setDate((java.sql.Date)datalist[2]);
			
			attendance.setName((String)datalist[3]);
			attendance.setFathername((String)datalist[4]);
			
			attendance.setDay1((String)datalist[5]);
			attendance.setDay2((String)datalist[6]);
			attendance.setDay3((String)datalist[7]);
			attendance.setDay4((String)datalist[8]);
			attendance.setDay5((String)datalist[9]);
			attendance.setDay6((String)datalist[10]);
			attendance.setDay7((String)datalist[11]);
			attendance.setDay8((String)datalist[12]);
			attendance.setDay9((String)datalist[13]);
			attendance.setDay10((String)datalist[14]);
			attendance.setDay11((String)datalist[15]);
			attendance.setDay12((String)datalist[16]);
			attendance.setDay13((String)datalist[17]);
			attendance.setDay14((String)datalist[18]);
			attendance.setDay15((String)datalist[19]);
			attendance.setDay16((String)datalist[20]);
			attendance.setDay17((String)datalist[21]);
			attendance.setDay18((String)datalist[22]);
			attendance.setDay19((String)datalist[23]);
			attendance.setDay20((String)datalist[24]);
			attendance.setDay21((String)datalist[25]);
			attendance.setDay22((String)datalist[26]);
			attendance.setDay23((String)datalist[27]);
			attendance.setDay24((String)datalist[28]);
			attendance.setDay25((String)datalist[29]);
			attendance.setDay26((String)datalist[30]);
			attendance.setDay27((String)datalist[31]);
			attendance.setDay28((String)datalist[32]);
			attendance.setDay29((String)datalist[33]);
			attendance.setDay30((String)datalist[34]);
			attendance.setDay31((String)datalist[35]);
			
			attendance.setLessonStart((String)datalist[37]);
			attendance.setLessonEnd((String)datalist[38]);
			
		//	attendance.setMadrasaname((String)datalist[9]);
			//attendance.setClassname((String)datalist[10]);
			
			attendanceList.add(attendance);		
		});

		return JsonUtil.convertIntoJson(attendanceList);
	}
	
	

	@Override
	public ResponseEntity<JSONResponse<?>> getUser(long id) {

		/*String sql = "SELECT u.id,u.name, u.fatherName,u.dob,u.doj, u.createdOn, ud.fathernic, ud.permaddress AS address, ud.locationId AS location, ud.teacherId, ud.shiftId, ud.classId,"
				+ " ud.contact1,ud.contact2,ud.contact3, u.image  "
				+ "FROM `user` u LEFT JOIN userdetails ud ON u.id = ud.userId LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` WHERE u.id = :q1 LIMIT 1";
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
				",u.nic "+
				",u.userTypeId "+
				",ud.guardianname "+
				",ud.guardiannic "+
				",ud.guardianrelation "+
				",ud.maritalStatus "+
				",ud.gardiannumber "+
				",u.passwordSalt "+
			" FROM user u "+
				"LEFT JOIN userdetails ud ON u.id = ud.userId "+
				"LEFT JOIN `teacher_student` ts ON u.id = ts.`studentId` "+
			" WHERE u.id = :q1 LIMIT 1 ";
		
		EntityManager enityManager = entityManagerFactory.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id);

		try {
			
			Object[] users = (Object[]) query.getSingleResult();
			StudentVO user = new StudentVO();
			
			String password = (String)users[40];
			
			TrippleDes td= new TrippleDes();
					
			
			String decodedPassword  = td.decrypt(password);
			
			user.setId((BigInteger) users[0]);
			user.setName((String)users[1]);
			user.setUsername((String)users[2]);
			//user.setPassword(decodedPassword);
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
			
			user.setNic((String)users[33]);
			user.setUserTypeId((String)users[34]);
			
			user.setGuardianname((String)users[35]);
			user.setGuardiannic((String)users[36]);
			user.setGuardianrelation((String)users[37]);
			user.setMaritalStatus((Byte)users[38]);
			user.setGardiannumber((String)users[39]);
			user.setPasswordSalt(decodedPassword);
			
		
			
					/*	(BigInteger) student[0]
					,(String) student[1]
					,(String) student[2]
					,(Date) student[3]
					,(Date) student[4]
					,(Date) student[5]
					,(String) student[6]
					,(String) student[7]
					,(String) student[8]
					,(String) student[9]
					,(String) student[10]
					,(String) student[11]
					,(String) student[12]
					,(String) student[13]
					,(String) student[14]
					,(String) student[15]
					,(String) student[16]
					,(String) student[17]
					,(String) student[18]
					,(Date) student[19]
					,(Date) student[20]
					,(Date) student[21]
					,(String) student[22]
					,(String) student[23]
					,(String) student[24]
					,(String) student[25]
					,(String) student[26]
					,(String) student[27]
					,(String) student[28]
					,(String) student[29]
					,(String) student[30]
					,(String) student[31]
					,(String) student[32]*/
			//	);

			return JsonUtil.convertSingleEntityToJson(user);

		} catch (NoResultException e) {
			return null;
		}
		catch (Exception e) {
			return null;
			
		}
		
	}

	@Override
	public UserAuthorityEntity saveUserAuthority(UserEntity insertedUser, Date currentTime) {
		UserAuthorityEntity authorityEntity = new UserAuthorityEntity(); 
		
		if("3".equals(insertedUser.getUserTypeId())) {
		
			authorityEntity.setCreatedOn(currentTime);
			authorityEntity.setLastUpdatedOn(currentTime);
			authorityEntity.setStatus("A");
			authorityEntity.setAuthorityId(2);
			authorityEntity.setUserId(insertedUser.getId());
			
			return userAuthority.save(authorityEntity);
		}
		
		return null;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> usersByTypeAndMadarsa(List<Long> madarsaId, String userTypeId) {
		Collection<?> users =  userDAO.findByMadarsaIdAndUserTypeIdIn(madarsaId,userTypeId);
		return JsonUtil.convertIntoJson(users);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getUserDetails(long id) {
		UserEntity user =  userDAO.findById(id);
		return JsonUtil.convertSingleEntityToJson(user);
		
	/*	String sql = "SELECT u.id,u.name, u.fatherName,u.dob,u.doj, u.createdOn, ud.fathernic, ud.permaddress AS address, ud.locationId AS location, ud.teacherId, ud.shiftId, ud.classId,"
				+ " ud.contact1,ud.contact2,ud.contact3, u.image  "
				+ "FROM UserEntity u LEFT JOIN UserDetailsEntity ud ON u.id = ud.userId LEFT JOIN TeacherStudentEntity ts ON u.id = ts.studentId WHERE u.id = :q1";
		 //LIMIT 1

	    //EntityManager em = emf.createEntityManager();

		Query query = (Query) enityManager.createNativeQuery(sql);
		query.setParameter("q1", id);
		//UserEntity persons =  em.createQuery(sql, UserEntity.class).setParameter("q1", id).setMaxResults(1).getSingleResult();
		return JsonUtil.convertSingleEntityToJson(persons);*/

	/*	try {
			
			Object[] student = (Object[]) query.getSingleResult();
			StudentVO std = new StudentVO((BigInteger) student[0], (String) student[1], (String) student[2],
					(Date) student[3], (Date) student[4], (Date) student[5], (String) student[6], (String) student[7],
					(String) student[8], (String) student[9], (String) student[10], (String) student[11], (String) student[12],(String)  student[13], (String) student[14], (String) student[15]);

			return JsonUtil.convertSingleEntityToJson(std);

		} catch (NoResultException e) {
			return null;
		}*/
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getStudentCount() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
				String sql = " select count(*) TotalCount from user where usertypeid  = 4 ";
				
				EntityManager enityManager = entityManagerFactory.createEntityManager();

				Query query = (Query) enityManager.createNativeQuery(sql);
				//query.setParameter("q1", username);

				try {
					
					ArrayList<String> list = new ArrayList<String>();
					
					Object studentRecords = query.getSingleResult();
					
				
					
					list.add(studentRecords.toString());
					
			
					
					
					return JsonUtil.convertIntoJson(list);

				} catch (NoResultException e) {
					return null;
				}
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getTeacherCount() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
				String sql = " select count(*) TotalCount from user where usertypeid  = 2 ";
				
				EntityManager enityManager = entityManagerFactory.createEntityManager();

				Query query = (Query) enityManager.createNativeQuery(sql);
				//query.setParameter("q1", username);

				try {
					
					ArrayList<String> list = new ArrayList<String>();
					
					Object studentRecords = query.getSingleResult();
					
				
					
					list.add(studentRecords.toString());
					
			
					
					
					return JsonUtil.convertIntoJson(list);

				} catch (NoResultException e) {
					return null;
				}
	}

	
	public static String encrypt(String strClearText) throws Exception{
		String strData="";
		
		try {
			String strKey ="serialKey";
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	
	public static String decrypt(String strEncrypted) throws Exception{
		String strData="";
		
		try {
			String strKey ="serialKey";
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> saveImages(CommonUserVO student , String imageath ) {
		// TODO Auto-generated method stub
		
		
		try {
			
			if (student.getImageString() != null) {
				byte[] byteImage = FileUploadUtils.decode(student.getImageString());
			
				String path = FileUploadUtils.UploadFile(byteImage, imageath);
				path = path.split("web")[2];
				student.setImage(path);
			}
			
		} catch (Exception e) {
			
		}
		
		return null;
	}

	@Override
	public ResponseEntity<JSONResponse<?>> getDecoded(String pwd) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		try {
			TrippleDes td = new TrippleDes();
			list.add(td.decrypt(pwd));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return JsonUtil.convertIntoJson(list);
	}
	



}
