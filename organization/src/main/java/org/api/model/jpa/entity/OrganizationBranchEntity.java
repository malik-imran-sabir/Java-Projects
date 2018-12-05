package org.api.model.jpa.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="organizationbranch")
public class OrganizationBranchEntity extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private String location;
	
	@Column(name = "lat")
	private String lat;
	
	@Column(name = "lng")
	private String lng;
	
	@Column
	private Long nigranid;
	
	@ManyToOne
	@JoinColumn(name="organizationId")
	private OrganizationEntity organizationId;
	
	@OneToMany(mappedBy="organizationBranchId")
	private Collection<OrganizationBranchUserEntity> branchUsers;

	@Column
	private String image;
	
	@Transient
	private String nigran;
	
	@Column
	private String locationLabel;

	@Column
	private String areaHeadName;
	
	@Column
	private String firstWitnessName;
	
	@Column
	private String firstWitnessPhone;
	
	@Column
	private String secondWitnessName;
	
	@Column
	private String secondWitnessPhone;
	
	@Column
	private String sponsoredAmount;
	
	@Column
	private String isSchoolExists;
	
	@Column
	private String areaPopulation;
	
	@Column
	private String madarsacode;
	
	@Column
	private Date madarsastartedfrom;
	
	@Column
	private String sarbrahmobilenumber;
	
	public OrganizationEntity getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(OrganizationEntity organizationId) {
		this.organizationId = organizationId;
	}

	public Collection<OrganizationBranchUserEntity> getBranchUsers() {
		return branchUsers;
	}

	public void setBranchUsers(Collection<OrganizationBranchUserEntity> branchUsers) {
		this.branchUsers = branchUsers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getNigranid() {
		return nigranid;
	}

	public void setNigranid(Long nigranid) {
		this.nigranid = nigranid;
	}
	

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLat() {
		return lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getNigran() {
		return nigran;
	}

	public void setNigran(String nigran) {
		this.nigran = nigran;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocationLabel() {
		return locationLabel;
	}

	public void setLocationLabel(String locationLabel) {
		this.locationLabel = locationLabel;
	}

	public String getAreaHeadName() {
		return areaHeadName;
	}

	public void setAreaHeadName(String areaHeadName) {
		this.areaHeadName = areaHeadName;
	}

	public String getFirstWitnessName() {
		return firstWitnessName;
	}

	public void setFirstWitnessName(String firstWitnessName) {
		this.firstWitnessName = firstWitnessName;
	}

	public String getFirstWitnessPhone() {
		return firstWitnessPhone;
	}

	public void setFirstWitnessPhone(String firstWitnessPhone) {
		this.firstWitnessPhone = firstWitnessPhone;
	}

	public String getSecondWitnessName() {
		return secondWitnessName;
	}

	public void setSecondWitnessName(String secondWitnessName) {
		this.secondWitnessName = secondWitnessName;
	}

	public String getSponsoredAmount() {
		return sponsoredAmount;
	}

	public void setSponsoredAmount(String sponsoredAmount) {
		this.sponsoredAmount = sponsoredAmount;
	}

	public String getSecondWitnessPhone() {
		return secondWitnessPhone;
	}

	public void setSecondWitnessPhone(String secondWitnessPhone) {
		this.secondWitnessPhone = secondWitnessPhone;
	}

	public String getIsSchoolExists() {
		return isSchoolExists;
	}

	public void setIsSchoolExists(String isSchoolExists) {
		this.isSchoolExists = isSchoolExists;
	}

	public String getAreaPopulation() {
		return areaPopulation;
	}

	public void setAreaPopulation(String areaPopulation) {
		this.areaPopulation = areaPopulation;
	}

	public String getMadarsacode() {
		return madarsacode;
	}

	public void setMadarsacode(String madarsacode) {
		this.madarsacode = madarsacode;
	}

	public Date getMadarsastartedfrom() {
		return madarsastartedfrom;
	}

	public void setMadarsastartedfrom(Date madarsastartedfrom) {
		this.madarsastartedfrom = madarsastartedfrom;
	}

	public String getSarbrahmobilenumber() {
		return sarbrahmobilenumber;
	}

	public void setSarbrahmobilenumber(String sarbrahmobilenumber) {
		this.sarbrahmobilenumber = sarbrahmobilenumber;
	}

	
	
	
	
}
