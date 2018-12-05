package org.api.services.impl;

import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

import org.api.model.jpa.dao.JPAUserTypeDAO;
import org.api.model.jpa.entity.UserEntity;
import org.api.model.jpa.entity.UserTypeEntity;
import org.api.vo.UserTypeVO;
import org.api.vo.CommonUserVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.core.util.JsonUtil;
import org.core.view.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("UserTypeService")
public class UserTypeServiceImpl extends CRUDServiceImpl<UserTypeEntity, UserTypeVO>implements UserTypeService{

	@Autowired
	private JPAUserTypeDAO userType;
	
	public UserTypeServiceImpl(BaseDAO<UserTypeEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(UserTypeVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, UserTypeEntity.class);
		
	}

	@Override
	public <ENTITY extends BaseEntity> UserTypeVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, UserTypeVO.class);
	}

	@Override
	public ResponseEntity<JSONResponse<?>> userTypeById(long typeId) {
		JsonUtil util =  new JsonUtil();
		 Collection<UserTypeEntity> records = (Collection<UserTypeEntity>) userType.findById(typeId);
		 return util.convertIntoJson(records);
	}
}
