package org.api.vo;

import java.math.BigInteger;
import java.util.Date;

public class StudentVO {

	private BigInteger id;
	private String name;
	private String fatherName;
	private String username;
	private String password;
	private Date dob;
	private Date doj;
	private Date createdOn;
	private String image;
	private String location;
	private String status;
	private String address;
	private String fathernic;
	private String teacherId;
	private String shiftId;
	private String classId;
	private String contact1;
	private String contact2;
	private String contact3;
	private String permaddress;
	private String tempaddress;
	private String locationId;
	private String madarsaId;
	private String easyaccounttitle;
	private String emobilenumber;
	private String enic;
	private String benefitamount;
	private String salary;
	private int maritalStatus;
	private String qualification;
	private String extraQualification;
	private String modernQualification;
	private String lastAttendedMadarsa;
	private String otherMadarsas;
	private Date lastQualificationDate;
	private String nic;
	private String userTypeId;
	
	private String guardianname;
	private String guardiannic;
	private String guardianrelation;
	private String gardiannumber;
	
	private String passwordSalt;
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFathernic() {
		return fathernic;
	}

	public void setFathernic(String fathernic) {
		this.fathernic = fathernic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getContact3() {
		return contact3;
	}

	public void setContact3(String contact3) {
		this.contact3 = contact3;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPermaddress() {
		return permaddress;
	}

	public void setPermaddress(String permaddress) {
		this.permaddress = permaddress;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getMadarsaId() {
		return madarsaId;
	}

	public void setMadarsaId(String madarsaId) {
		this.madarsaId = madarsaId;
	}

	public String getEasyaccounttitle() {
		return easyaccounttitle;
	}

	public void setEasyaccounttitle(String easyaccounttitle) {
		this.easyaccounttitle = easyaccounttitle;
	}

	public String getEmobilenumber() {
		return emobilenumber;
	}

	public void setEmobilenumber(String emobilenumber) {
		this.emobilenumber = emobilenumber;
	}

	public String getEnic() {
		return enic;
	}

	public void setEnic(String enic) {
		this.enic = enic;
	}

	public String getBenefitamount() {
		return benefitamount;
	}

	public void setBenefitamount(String benefitamount) {
		this.benefitamount = benefitamount;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExtraQualification() {
		return extraQualification;
	}

	public void setExtraQualification(String extraQualification) {
		this.extraQualification = extraQualification;
	}

	public String getModernQualification() {
		return modernQualification;
	}

	public void setModernQualification(String modernQualification) {
		this.modernQualification = modernQualification;
	}

	public String getLastAttendedMadarsa() {
		return lastAttendedMadarsa;
	}

	public void setLastAttendedMadarsa(String lastAttendedMadarsa) {
		this.lastAttendedMadarsa = lastAttendedMadarsa;
	}

	public String getOtherMadarsas() {
		return otherMadarsas;
	}

	public void setOtherMadarsas(String otherMadarsas) {
		this.otherMadarsas = otherMadarsas;
	}

	public Date getLastQualificationDate() {
		return lastQualificationDate;
	}

	public void setLastQualificationDate(Date lastQualificationDate) {
		this.lastQualificationDate = lastQualificationDate;
	}

	public String getTempaddress() {
		return tempaddress;
	}

	public void setTempaddress(String tempaddress) {
		this.tempaddress = tempaddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getGuardianname() {
		return guardianname;
	}

	public void setGuardianname(String guardianname) {
		this.guardianname = guardianname;
	}

	public String getGuardiannic() {
		return guardiannic;
	}

	public void setGuardiannic(String guardiannic) {
		this.guardiannic = guardiannic;
	}

	public String getGuardianrelation() {
		return guardianrelation;
	}

	public void setGuardianrelation(String guardianrelation) {
		this.guardianrelation = guardianrelation;
	}

	public String getGardiannumber() {
		return gardiannumber;
	}

	public void setGardiannumber(String gardiannumber) {
		this.gardiannumber = gardiannumber;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

//	public int getUserTypeId() {
//		return userTypeId;
//	}
//
//	public void setUserTypeId(int userTypeId) {
//		this.userTypeId = userTypeId;
//	}
}
