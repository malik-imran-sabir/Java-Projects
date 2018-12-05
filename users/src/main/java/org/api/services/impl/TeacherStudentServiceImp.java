package org.api.services.impl;

import java.io.Serializable;

import org.api.model.jpa.entity.TeacherStudentEntity;
import org.api.vo.TeacherStudentVO;
import org.core.model.dao.BaseDAO;
import org.core.model.entity.BaseEntity;
import org.core.service.CRUDServiceImpl;
import org.core.util.BeanUtils;
import org.springframework.stereotype.Service;

@Service("teacherStudent")
public class TeacherStudentServiceImp extends CRUDServiceImpl<TeacherStudentEntity, TeacherStudentVO> {

	public TeacherStudentServiceImp(BaseDAO<TeacherStudentEntity, Serializable> dao) {
		super(dao);
	}

	@Override
	public <ENTITY extends BaseEntity> ENTITY getDeepCopiedEntity(TeacherStudentVO source) throws Throwable {
		return (ENTITY) BeanUtils.shallowCopy(source, TeacherStudentEntity.class);
	}

	@Override
	public <ENTITY extends BaseEntity> TeacherStudentVO getDeepCopiedVO(ENTITY source) throws Throwable {
		return BeanUtils.shallowCopy(source, TeacherStudentVO.class);
	}

}
