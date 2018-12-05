package org.api.model.jpa.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity {
	
	
	private long id;
	
	@Column
	private String name;
	
	@Column(name = "fatherName")
	private String fatherName;
	
	@Column
	private String password;
	
	@Column
	private Date dob;
	
	@Column
	private Date doj;
	
	@Column
	private String nic;
	
	@Column(name = "userTypeId")
	private String userTypeId;
	
	@Column(name = "madarsaId")
	private long madarsaId;
	
	@Column
	private String username;

	@Column
	private String location;
	
	@Column
	private String image;
	
	@Column
	private String passwordSalt; 
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "user")
	//@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "user", optional  = false)
	private UserDetailsEntity userDetails;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "userTypeId", insertable=false , updatable=false)
	private UserTypeEntity userType;
	
	public String getName() {
		return name;
	}

	public String getNic() {
		return nic;
	}

	public void setName(String name) {
		this.name = name;
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

	public UserTypeEntity getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEntity userType) {
		this.userType = userType;
	}
	/*
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getMadarsaId() {
		return madarsaId;
	}

	public void setMadarsaId(long madarsaId) {
		this.madarsaId = madarsaId;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
		//userDetails.setUser(this); 
		
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
}
