package org.api.services.impl;

import java.io.Serializable;

import org.api.model.jpa.entity.OrganizationBranchEntity;
import org.api.model.jpa.entity.OrganizationBranchUserEntity;
import org.api.model.jpa.entity.OrganizationEntity;
import org.api.vo.OrganizationBranchUserVO;
import org.api.vo.OrganizationBranchVO;
import org.core.model.dao.BaseDAO;
import org.core.model.dao.BaseJPADAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.vo.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("OrganizationBranchUserService")
@Transactional
public class OrganizationBranchUserServiceImpl extends CRUDServiceImpl<OrganizationBranchUserEntity, OrganizationBranchUserVO>implements OrganizationBranchUserService{

	public OrganizationBranchUserServiceImpl(BaseDAO<OrganizationBranchUserEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(OrganizationBranchUserVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, OrganizationBranchUserEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> OrganizationBranchUserVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, OrganizationBranchUserVO.class);

	}

	
}
