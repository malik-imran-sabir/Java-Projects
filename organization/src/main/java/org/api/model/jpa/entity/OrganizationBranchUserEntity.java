package org.api.model.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="organizationbranchuser")
public class OrganizationBranchUserEntity extends BaseEntity{

	
	@ManyToOne
	@JoinColumn(name="organizationBranchId")
	private OrganizationBranchEntity organizationBranchId;
	
	@Column
	private Long  userId;
	
	public OrganizationBranchEntity getOrganizationBranchId() {
		return organizationBranchId;
	}

	public void setOrganizationBranchId(OrganizationBranchEntity organizationBranchId) {
		this.organizationBranchId = organizationBranchId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	
	
	
}
