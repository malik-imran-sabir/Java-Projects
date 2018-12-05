package org.api.model.jpa.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="organization")
public class OrganizationEntity extends BaseEntity{

	@Column
	private String name;

	@Column
	private String location;
	
	@OneToMany(mappedBy="organizationId")
	private Collection<OrganizationBranchEntity> organizationBranches;

	public Collection<OrganizationBranchEntity> getOrganizationBranches() {
		return organizationBranches;
	}

	public void setOrganizationBranches(Collection<OrganizationBranchEntity> organizationBranches) {
		this.organizationBranches = organizationBranches;
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
	
	
	
}
