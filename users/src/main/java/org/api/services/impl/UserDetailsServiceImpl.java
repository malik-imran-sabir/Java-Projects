package org.api.services.impl;

import java.io.Serializable;

import org.api.model.jpa.entity.UserDetailsEntity;
import org.api.vo.UserDetailsVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * The Class UserServiceImpl.
 */
@Service("UserDetailsServiceImp")
public class UserDetailsServiceImpl extends CRUDServiceImpl<UserDetailsEntity, UserDetailsVO>{

	public UserDetailsServiceImpl(BaseDAO<UserDetailsEntity, Serializable> dao) {
		super(dao);
	}
	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(UserDetailsVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, UserDetailsEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> UserDetailsVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, UserDetailsVO.class);
	}

}
