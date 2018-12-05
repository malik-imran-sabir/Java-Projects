package org.api.model.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userdetails")
public class UserDetailsEntity extends BaseEntity{
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private UserEntity user;
	
	private long id;
	
	@Column
	private long userId;
	
	@Column
	private String fathernic;
	@Column
	private String address;
	@Column
	private String permaddress;
	@Column
	private String tempaddress;
	@Column
	private String locationId;
	@Column
	private String teacherId;
	@Column
	private String shiftId;
	@Column
	private String classId;
	@Column
	private String madarsaId;
	@Column
	private String easyaccounttitle;
	@Column
	private String emobilenumber;
	@Column
	private String enic;
	@Column
	private String benefitamount;
	@Column
	private String salary;
	@Column
	private String contact1;
	@Column
	private String contact2;
	@Column
	private String contact3;
	@Column
	private boolean maritalStatus;
	@Column
	private String qualification;
	@Column
	private String extraQualification;
	@Column
	private String modernQualification;
	@Column
	private String lastAttendedMadarsa;
	@Column
	private String otherMadarsas;
	
	@Column
	private Date lastQualificationDate;
	
	@Column
	private String guardianname;
	
	@Column
	private String guardiannic;
	
	@Column
	private String guardianrelation;
	
	@Column
	private String gardiannumber;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public boolean isMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(boolean maritalStatus) {
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
	public String getTempaddress() {
		return tempaddress;
	}
	public void setTempaddress(String tempaddress) {
		this.tempaddress = tempaddress;
	}
	public Date getLastQualificationDate() {
		return lastQualificationDate;
	}
	public void setLastQualificationDate(Date lastQualificationDate) {
		this.lastQualificationDate = lastQualificationDate;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
}
