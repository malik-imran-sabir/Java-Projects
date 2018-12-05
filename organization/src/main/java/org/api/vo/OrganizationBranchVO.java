package org.api.vo;


import java.sql.Date;

import javax.persistence.Column;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class OrganizationBranchVO extends BaseVO {

	private String name;
	
	private String location;
	
	private OrganizationVO organizationId;

	private OrganizationBranchUserVO branchUsers;

	private String image;
	
	private String locationLabel;
	
	private String lat;
	
	private String lng;
	
	private long nigranid;
	
	private String areaHeadName;

	private String firstWitnessName;
	
	private String firstWitnessPhone;
	
	private String secondWitnessName;
	
	private String secondWitnessPhone;
	
	private String sponsoredAmount;
	
	private String isSchoolExists;
	
	private String areaPopulation;
	
	private String madarsacode;
	
	private Date madarsastartedfrom;
	
	private String sarbrahmobilenumber;
	
	private String imageString;
	
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	
	public OrganizationVO getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(OrganizationVO organizationId) {
		this.organizationId = organizationId;
	}

	public OrganizationBranchUserVO getBranchUsers() {
		return branchUsers;
	}

	public void setBranchUsers(OrganizationBranchUserVO branchUsers) {
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

	public long getNigranid() {
		return nigranid;
	}

	public void setNigranid(long nigranid) {
		this.nigranid = nigranid;
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

	public String getSponsoredAmount() {
		return sponsoredAmount;
	}

	public void setSponsoredAmount(String sponsoredAmount) {
		this.sponsoredAmount = sponsoredAmount;
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

	public String getSarbrahmobilenumber() {
		return sarbrahmobilenumber;
	}

	public void setSarbrahmobilenumber(String sarbrahmobilenumber) {
		this.sarbrahmobilenumber = sarbrahmobilenumber;
	}

	public Date getMadarsastartedfrom() {
		return madarsastartedfrom;
	}

	public void setMadarsastartedfrom(Date madarsastartedfrom) {
		this.madarsastartedfrom = madarsastartedfrom;
	}

	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}


	

}
