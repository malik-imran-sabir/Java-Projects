package org.api.vo;

import java.util.Collection;

import org.api.model.jpa.entity.OrganizationBranchEntity;
import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrganizationVO extends BaseVO{

	private String location;
	private String name;
	private Collection<OrganizationBranchVO> organizationBranches;

	public Collection<OrganizationBranchVO> getOrganizationBranches() {
		return organizationBranches;
	}

	public void setOrganizationBranches(Collection<OrganizationBranchVO> organizationBranches) {
		this.organizationBranches = organizationBranches;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
