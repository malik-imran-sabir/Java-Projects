package org.api.vo;


import org.api.model.jpa.entity.OrganizationBranchEntity;
import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class OrganizationBranchUserVO extends BaseVO{

	private OrganizationBranchEntity organizationBranchId;
	
	private Long userId;
	
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
