package org.api.vo;

import java.math.BigInteger;

public class LocationModel {
	private BigInteger id;
	private String name;
	
	public LocationModel(BigInteger id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
}
