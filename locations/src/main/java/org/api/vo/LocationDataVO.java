package org.api.vo;

import org.core.vo.BaseVO;

public class LocationDataVO extends BaseVO{

	private String name;
	private long id;
	private String country;
	private String province;
	private String district;
	private String value;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	//private Collection<LocationDataVO> locationMappingData ;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	/*public Collection<LocationDataVO> getLocationMappingData() {
		return locationMappingData;
	}
	
	public void setLocationMappingData(Collection<LocationDataVO> locationMappingData) {
		this.locationMappingData = locationMappingData;
	}*/
	
}
