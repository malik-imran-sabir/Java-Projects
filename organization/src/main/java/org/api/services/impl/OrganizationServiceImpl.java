package org.api.services.impl;

import java.io.Serializable;

import org.api.model.jpa.entity.OrganizationEntity;
import org.api.vo.OrganizationVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.springframework.stereotype.Service;

@Service("OrganizationService")
public class OrganizationServiceImpl extends CRUDServiceImpl<OrganizationEntity, OrganizationVO>{

	public OrganizationServiceImpl(BaseDAO<OrganizationEntity, Serializable> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(OrganizationVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, OrganizationEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> OrganizationVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, OrganizationVO.class);
	}

	
}
